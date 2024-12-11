package com.intercambioregalos.util;


import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "secreto_super_seguro";

    public String generateToken(String nombreUsuario){
        return Jwts.builder()
                .setSubject(nombreUsuario)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
    public String extractnombreUsuario(String token){
        return getClaims(token).getSubject();

    }

    public boolean isTokenValid(String token) {
        return !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String jwt) {
        return jwt;
    }

}
