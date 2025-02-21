package com.example.demo.Controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.Contatos.Contatos;
import com.example.demo.Dependecy_Inject.Di;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
public class MyController {    
    @Autowired
    private Di contatos_di;

    @PostMapping("/contato")
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<Contatos> InserirContatos(@RequestBody @Valid Contatos contatos, UriComponentsBuilder uriBuilder) {
        Contatos cont = contatos;
        var uri = uriBuilder.path("/contato/{id}").buildAndExpand(cont.getId()).toUri();
        contatos_di.save(cont);  
        return ResponseEntity.created(uri).body(cont);
    }



    @GetMapping("/contato") //usar o paginable pra visualizar os contatos
    public ResponseEntity<Page<Contatos>> mostarContatos(Pageable pageable){
        Page<Contatos> cont = contatos_di.findAll(pageable);
        return ResponseEntity.ok(cont);
    }
   
    @GetMapping("/contato/{id}")
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<Contatos> mostrarPorID(@PathVariable Long id) {
        var cont = contatos_di.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));  

        return ResponseEntity.ok(cont);
    }

    @PutMapping("/contato/{id}")
    @Transactional(rollbackOn = Exception.class)


    public ResponseEntity<Contatos> atualizarContato(@PathVariable Long id, @RequestBody Contatos contato) {
        var contatoExistente = contatos_di.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato nao encontrado"));

        contatoExistente.setNome(contato.getNome());
        contatoExistente.setNumero(contato.getNumero());

        contatos_di.save(contatoExistente);
        return ResponseEntity.ok(contatoExistente);
    }



    @DeleteMapping("/contato/{id}")
    @Transactional(rollbackOn = Exception.class)

    public ResponseEntity<Contatos> deletarContato(@PathVariable Long id) {
        Contatos contatoExistente = contatos_di.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));
        
        contatos_di.delete(contatoExistente); 
        return ResponseEntity.noContent().build();
    }

    
}
