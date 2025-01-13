package com.espe.micro_Evento.repositories;

import com.espe.micro_Evento.models.entities.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento, Long> {
}
