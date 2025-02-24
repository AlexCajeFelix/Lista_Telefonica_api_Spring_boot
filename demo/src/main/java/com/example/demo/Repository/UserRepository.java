package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.Usuarios.Usuarios;

public interface UserRepository extends JpaRepository <Usuarios, Long>{

    UserDetails findByLogin(String username);
    
}
