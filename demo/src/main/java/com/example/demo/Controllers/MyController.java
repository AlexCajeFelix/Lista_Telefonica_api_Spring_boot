package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Contatos.Contatos;
import com.example.demo.Dependecy_Inject.Di;

import jakarta.validation.Valid;

@RestController
public class MyController {    
    @Autowired
    private Di contatos_di;

    @PostMapping("/contato")
    public Contatos InserirContatos(@RequestBody @Valid Contatos contatos){
        contatos_di.save(contatos);  
        return contatos;
    }

    @GetMapping("/contato")
    public List<Contatos> mostarContatos(Contatos contatos){
        return contatos_di.findAll();
    }
   
    @GetMapping("/contato/{id}")
    public Contatos mostrarPorID(@PathVariable Long id) {
        return contatos_di.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));  
    }

    @PutMapping("/contato/{id}")
    public Contatos atualizarContato(@PathVariable Long id, @RequestBody Contatos contato) {
        Contatos contatoExistente = contatos_di.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato nao encontrado"));

        contatoExistente.setNome(contato.getNome());
        contatoExistente.setNumero(contato.getNumero());

        return contatos_di.save(contatoExistente);
    }
    @DeleteMapping("/contato/{id}")
    public void deletarContato(@PathVariable Long id) {
        Contatos contatoExistente = contatos_di.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado"));
        
        contatos_di.delete(contatoExistente); 
    }

    
}
