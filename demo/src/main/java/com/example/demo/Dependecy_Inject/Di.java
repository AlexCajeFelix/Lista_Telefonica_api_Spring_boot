package com.example.demo.Dependecy_Inject;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Contatos.Contatos;

public interface Di  extends JpaRepository<Contatos, Long> {
    
}
