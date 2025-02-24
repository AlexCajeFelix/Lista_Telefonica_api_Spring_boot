package com.example.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Contatos.Contatos;

public interface ContactsRepository extends JpaRepository<Contatos, Long> {
   
    Page<Contatos> findAll(Pageable pageable);
}
