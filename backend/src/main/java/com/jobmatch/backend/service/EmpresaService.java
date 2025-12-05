package com.jobmatch.backend.service;

import com.jobmatch.backend.model.Empresa;
import com.jobmatch.backend.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    // 1. Obtener todas las empresas
    public List<Empresa> listarTodas() {
        return empresaRepository.findAll();
    }

    // 2. Guardar una empresa (Crear o Actualizar)
    public Empresa guardarEmpresa(Empresa empresa) {
        // Aquí podrías agregar validaciones extra si quisieras (ej: verificar rut)
        return empresaRepository.save(empresa);
    }

    // 3. Buscar por ID
    public Optional<Empresa> obtenerPorId(Long id) {
        return empresaRepository.findById(id);
    }

    // 4. Eliminar por ID
    public void eliminarEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}