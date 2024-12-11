package com.intercambioregalos.service;


import com.intercambioregalos.model.User;
import com.intercambioregalos.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsuarioServicio {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServicio(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public String registroUsuario(User user){
        if (usuarioRepository.findByUsername(user.getNombreUsuario()).isPresent()){
            return "El usuario ya existe";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usuarioRepository.save(user);
        return "Usuario registrado con éxito.";
    }
    public Optional<User> findByUsername(String nombreUsuario) {
        return usuarioRepository.findByUsername(nombreUsuario);
    }

}
