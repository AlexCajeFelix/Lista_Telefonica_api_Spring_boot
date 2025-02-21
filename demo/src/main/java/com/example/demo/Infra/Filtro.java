package com.example.demo.Infra;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.Dependecy_Inject.Di;
import com.example.demo.Dependecy_Inject.Di2;
import com.example.demo.TokenService.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class Filtro extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private Di2 di2;

    private Di di;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var token = recuperarToken(request);

        if (token != null) {
            var subject = tokenService.getSubject(token);

            // Verifica se o subject foi obtido corretamente e configura a autenticação
            if (subject != null) {
                // Busca o usuário na base de dados (ou através de outro método)
                var usuario = di2.findByLogin(subject);  // di2 ou outro serviço que você utiliza para buscar o usuário

                if (usuario != null) {
                    var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var token = request.getHeader("Authorization");

        if (token == null || !token.startsWith("Bearer ")) {
            return null;
        }

        return token.substring(7);  // Remove o prefixo "Bearer " do token
    }
}
