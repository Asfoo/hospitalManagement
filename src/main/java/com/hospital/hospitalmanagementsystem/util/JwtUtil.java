package com.hospital.hospitalmanagementsystem.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = "9543957B366B64BC8DBDAFC3C9CE6"; // Replace with a secure key
    private static final long EXPIRATION_TIME = 86400000; // 1 day in milliseconds

    // Generate a token
    public static String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // Validate the token and retrieve the claims
    public static boolean validateToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    // Check if the token is expired
    public static boolean isTokenExpired(String token) {
        return validateToken(token).getExpiration().before(new Date());
    }

    // Retrieve the email (subject) from the token
    public static String getEmailFromToken(String token) {
        return validateToken(token).getSubject();
    }
}
