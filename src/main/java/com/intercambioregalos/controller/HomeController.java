package com.intercambioregalos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String loginPage() {
        return "redirect:/html/login.html";
    }

    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "redirect:/html/dashboard.html";
    }

    @GetMapping("/asignaciones")
    public String asignacionesPage() {
        return "redirect:/html/asignaciones.html";
    }

    @GetMapping("/participantes")
    public String participantesPage() {
        return "redirect:/html/participantes.html";
    }

    @GetMapping("/consultar-destinatario")
    public String consultarDestinatarioPage() {
        return "redirect:/html/consultar-destinatario.html";
    }

    @GetMapping("/registro-usuario")
    public String registroUsuarioPage() {
        return "redirect:/html/registro-usuario.html";
    }
}