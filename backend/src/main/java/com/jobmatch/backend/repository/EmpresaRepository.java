package com.jobmatch.backend.repository;

import com.jobmatch.backend.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    // JpaRepository ya incluye: findAll, findById, save, deleteById, etc.
}