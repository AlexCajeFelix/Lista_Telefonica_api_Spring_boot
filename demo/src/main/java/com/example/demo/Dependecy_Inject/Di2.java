package com.example.demo.Dependecy_Inject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.Usuarios.Usuarios;

public interface Di2 extends JpaRepository <Usuarios, Long>{

    UserDetails findByLogin(String username);
    
}
