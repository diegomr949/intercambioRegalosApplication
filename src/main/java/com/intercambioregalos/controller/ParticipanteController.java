package com.intercambioregalos.controller;

import com.intercambioregalos.model.Participante;
import com.intercambioregalos.service.ParticipanteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ParticipanteController {
    private final ParticipanteService participanteService;

    public ParticipanteController(ParticipanteService participanteService) {
        this.participanteService = participanteService;
    }

    @PostMapping("/participantes")
    public String agregarParticipante(@RequestBody Participante participante){
        return participanteService.agregarParticipante(participante);
    }

    @GetMapping("/participantes")
    public List<Participante> getAllParticipantes(){
        return participanteService.getAllParticipantes();
    }

    @PostMapping("/asignaciones")
    public String asignarDestinatarios() {
        return participanteService.asignarDestinatarios();
    }

    @GetMapping("/destinatario/{email}")
    public String obtenerDestinatario(@PathVariable String email) {
        return participanteService.obtenerDestinatario(email);
    }
}
