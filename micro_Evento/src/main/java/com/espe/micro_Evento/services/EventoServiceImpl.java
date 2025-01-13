package com.espe.micro_Evento.services;

import com.espe.micro_Evento.models.entities.Evento;
import com.espe.micro_Evento.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService {
    @Autowired
    private EventoRepository repository;

    @Override
    public List<Evento> findAll() {
        return (List<Evento>) repository.findAll();
    }

    @Override
    public Optional<Evento> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Evento save(Evento evento) {
        return repository.save(evento);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
