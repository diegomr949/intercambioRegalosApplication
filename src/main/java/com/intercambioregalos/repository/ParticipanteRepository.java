package com.intercambioregalos.repository;

import com.intercambioregalos.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

    Optional<Participante> findByEmail(String email);

}
