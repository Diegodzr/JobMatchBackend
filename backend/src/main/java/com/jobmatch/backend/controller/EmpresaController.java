package com.jobmatch.backend.controller;

import com.jobmatch.backend.model.Empresa;
import com.jobmatch.backend.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas") // Esta será la URL base: http://localhost:8080/api/empresas
@CrossOrigin(origins = "http://localhost:3000")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    // GET: Listar todas
    @GetMapping
    public List<Empresa> listarEmpresas() {
        return empresaService.listarTodas();
    }

    // POST: Crear una nueva
    @PostMapping
    public Empresa crearEmpresa(@RequestBody Empresa empresa) {
        return empresaService.guardarEmpresa(empresa);
    }

    // GET: Obtener una por ID
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obtenerEmpresa(@PathVariable Long id) {
        return empresaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT: Actualizar (Edición)
    @PutMapping("/{id}")
    public ResponseEntity<Empresa> actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresaDetalles) {
        return empresaService.obtenerPorId(id)
                .map(empresaExistente -> {
                    empresaExistente.setNombreEmpresa(empresaDetalles.getNombreEmpresa());
                    empresaExistente.setCorreo(empresaDetalles.getCorreo());
                    empresaExistente.setDireccion(empresaDetalles.getDireccion());
                    empresaExistente.setTelefono(empresaDetalles.getTelefono());
                    empresaExistente.setDescripcion(empresaDetalles.getDescripcion());
                    
                    Empresa actualizada = empresaService.guardarEmpresa(empresaExistente);
                    return ResponseEntity.ok(actualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpresa(@PathVariable Long id) {
        if (empresaService.obtenerPorId(id).isPresent()) {
            empresaService.eliminarEmpresa(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}