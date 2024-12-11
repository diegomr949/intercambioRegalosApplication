package com.intercambioregalos.service;


import com.intercambioregalos.model.Participante;
import com.intercambioregalos.repository.ParticipanteRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteService {

    private final ParticipanteRepository participanteRepository;

    public ParticipanteService(ParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }


    public String agregarParticipante(Participante participante) {
        if (participanteRepository.findByEmail(participante.getEmail()).isPresent()) {
            return "El participante ya está registrado.";
        }
        participanteRepository.save(participante);
        return "Participante registrado con éxito.";
    }
    public List<Participante> getAllParticipantes(){
        return participanteRepository.findAll();

    }
    public String asignarDestinatarios() {
        List<Participante> participantes = participanteRepository.findAll();
        if (participantes.size() < 2) return "Debe haber al menos dos participantes.";

        Collections.shuffle(participantes);
        for (int i = 0; i < participantes.size(); i++) {
            Participante asignador = participantes.get(i);
            Participante destinatario = participantes.get((i + 1) % participantes.size());
            asignador.setEmailAsignado(destinatario.getEmail());
            participanteRepository.save(asignador);
        }
        return "Asignaciones realizadas con éxito.";
    }

    public String obtenerDestinatario(String email) {
        Optional<Participante> participanteOpt = participanteRepository.findByEmail(email);
        if (participanteOpt.isEmpty() || participanteOpt.get().getEmailAsignado() == null) {
            return "No se encontró destinatario.";
        }
        return participanteOpt.get().getEmailAsignado();
    }
}
