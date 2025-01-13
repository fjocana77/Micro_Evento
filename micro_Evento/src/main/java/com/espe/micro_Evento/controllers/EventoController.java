package com.espe.micro_Evento.controllers;

import com.espe.micro_Evento.models.entities.Evento;
import com.espe.micro_Evento.services.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {
    @Autowired
    private EventoService service;

    /**
     * Crear un nuevo evento.
     */
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Evento evento, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(
                    error -> errors.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(evento));
    }

    /**
     * Listar todos los eventos.
     */
    @GetMapping
    public List<Evento> listar() {
        return service.findAll();
    }

    /**
     * Buscar un evento por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable Long id) {
        Optional<Evento> eventoOptional = service.findById(id);
        if (eventoOptional.isPresent()) {
            return ResponseEntity.ok(eventoOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Editar un evento existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Evento evento, @PathVariable Long id, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(
                    error -> errors.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errors);
        }

        Optional<Evento> eventoOptional = service.findById(id);
        if (eventoOptional.isPresent()) {
            Evento eventoDB = eventoOptional.get();
            eventoDB.setNombre(evento.getNombre());
            eventoDB.setDescripcion(evento.getDescripcion());
            eventoDB.setDuracionHoras(evento.getDuracionHoras());
            eventoDB.setFechaInicio(evento.getFechaInicio());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(eventoDB));
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Eliminar un evento por su ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Evento> eventoOptional = service.findById(id);
        if (eventoOptional.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}