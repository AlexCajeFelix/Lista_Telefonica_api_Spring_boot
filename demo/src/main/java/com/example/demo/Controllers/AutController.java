package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dependecy_Inject.Di;
import com.example.demo.TokenService.TokenService;
import com.example.demo.TokenService.Token_dto;
import com.example.demo.Usuarios.Usuarios;
import com.example.demo.Usuarios.Usuarios_dto;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/aut")
public class AutController {

    @Autowired
    private AuthenticationManager manager;

  
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public  ResponseEntity efetuarLogin(@RequestBody @Valid Usuarios_dto dados) {
       
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(token);
        var tokenJWT = tokenService.gerarToken((Usuarios) authentication.getPrincipal());
        return ResponseEntity.ok(new Token_dto(tokenJWT));
    }   

    
   
}
