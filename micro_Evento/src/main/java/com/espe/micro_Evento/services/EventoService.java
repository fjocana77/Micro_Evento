package com.espe.micro_Evento.services;

import com.espe.micro_Evento.models.entities.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoService {

    List<Evento> findAll();

    Optional<Evento> findById(Long id);

    Evento save(Evento evento);

    void deleteById(Long id);
}
