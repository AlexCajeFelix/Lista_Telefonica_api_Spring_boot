package com.example.demo.TokenService;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.demo.Usuarios.Usuarios;

@Service
public class TokenService {

    //receber de uma variavel de ambiente 
    //so pra teste 
    private String secret = "123456";
    public String gerarToken(Usuarios usuario) {
        try {
            var algorithm = Algorithm.HMAC256(secret);  
            return JWT.create()
                    .withIssuer("apiAgenda")  
                    .withSubject(usuario.getLogin())  
                    .withExpiresAt(new java.util.Date(System.currentTimeMillis() + 18000000)) 
                    .sign(algorithm); 

        } catch (JWTCreationException exception) {
            System.out.println(exception.getMessage());  
            return null;
        }
    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256(secret)).build().verify(token).getSubject();
    }
}
