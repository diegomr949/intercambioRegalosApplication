package com.intercambioregalos.controller;

import com.intercambioregalos.model.User;
import com.intercambioregalos.service.UsuarioServicio;
import com.intercambioregalos.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return usuarioServicio.registroUsuario(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User foundUser = usuarioServicio.findByUsername(user.getNombreUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado."));
        if (!user.getPassword().equals(foundUser.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta.");
        }
        return jwtUtil.generateToken(foundUser.getNombreUsuario());
    }
}
