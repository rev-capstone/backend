package com.revature.config;

import java.security.Key;
import java.time.Instant;
import java.util.Date;

import com.revature.models.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class Jwtutil {
    static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public static String encode(User user){

        String jwt = null;
        try {
            new Date();
            jwt = Jwts.builder()
            .claim("id", user.getId())
            .claim("email", user.getEmail())
            .claim("password", user.getPassword())
            .claim("firstname", user.getFirstName())
            .claim("lastname", user.getLastName())
            .setExpiration(Date.from(Instant.now().plusMillis(86400*1000)))
            .signWith(key).compact();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        return jwt;

    }

    public static User decode(String jwt){

        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();

        User user = new User(Integer.parseInt(claims.get("id").toString()), claims.get("email").toString(), claims.get("password").toString(), claims.get("firstname").toString(), claims.get("lastname").toString());

        return user;
    } 
}
