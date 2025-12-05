package com.jobmatch.backend.repository;

import com.jobmatch.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Método de JPA para buscar por email aparte delos CRUD
    Optional<Usuario> findByEmail(String email);
}