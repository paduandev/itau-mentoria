package br.gama.jwtexample.security;


import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.gama.jwtexample.configuration.SecurityConstraints;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    private String SECRET_KEY = "012345678901234567890123456789012345678901234567890123456789012345678901234";

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> extracClaims = new HashMap<>();

        return Jwts.builder()
                .setClaims(extracClaims)
                .setSubject(userDetails.getUsername()) // Subject será o username 
                .setIssuer("Gama") //quem está gerando
                .setIssuedAt(new Date(System.currentTimeMillis())) // a data que foi gerado
                .setExpiration(Date.from(Instant.now().plus(SecurityConstraints.EXPIRATION_TIME_MINUTES, ChronoUnit.MINUTES)))
                .signWith(getSignKey(), SignatureAlgorithm.HS256) // qual algoritmo e qual a chave será utilizado
                .compact();
    }

    // transforma o texto da secret-key em uma chave usada para assinar o JWT
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {
        return extracClaims(token, Claims::getSubject);
    }

    public <T> T extracClaims(String token , Function <Claims, T> claimResolver) {
        Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(getSignKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    public boolean isTokenvalid(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        Date expiration = extracClaims(token, Claims::getExpiration);
        return username.equals(userDetails.getUsername()) && expiration.before(new Date());
    }
}
