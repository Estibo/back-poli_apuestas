package com.poli.apuestas.controller;

import com.poli.apuestas.model.Deporte;
import com.poli.apuestas.repository.DeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/deportes")
public class DeporteController {

    @Autowired
    private DeporteRepository deporteRepository;

    // GET: Listar todos los deportes
    @GetMapping
    public List<Deporte> listarDeportes() {
        return deporteRepository.findAll();
    }

    // GET: Obtener deporte por ID
    @GetMapping("/{id}")
    public ResponseEntity<Deporte> obtenerDeporte(@PathVariable int id) {
        Optional<Deporte> deporte = deporteRepository.findById(id);
        return deporte.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: Crear nuevo deporte
    @PostMapping
    public Deporte crearDeporte(@RequestBody Deporte deporte) {
        return deporteRepository.save(deporte);
    }

    // PUT: Actualizar deporte existente
    @PutMapping("/{id}")
    public ResponseEntity<Deporte> actualizarDeporte(@PathVariable int id, @RequestBody Deporte datosActualizados) {
        return deporteRepository.findById(id).map(deporteExistente -> {
            deporteExistente.setNombre(datosActualizados.getNombre());
            deporteRepository.save(deporteExistente);
            return ResponseEntity.ok(deporteExistente);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE: Eliminar deporte
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDeporte(@PathVariable int id) {
        if (deporteRepository.existsById(id)) {
            deporteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
