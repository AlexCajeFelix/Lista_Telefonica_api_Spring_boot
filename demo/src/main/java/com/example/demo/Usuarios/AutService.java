package com.example.demo.Usuarios;
//logica de autenticação

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Dependecy_Inject.Di2;

@Service
public class AutService implements UserDetailsService{

    @Autowired
    private Di2 di2;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return di2.findByLogin(username);
    }
   
    
}
