package com.angelblackblue.connextion.apirest.connextion_api_rest.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angelblackblue.connextion.apirest.connextion_api_rest.Entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, UUID> {

}
