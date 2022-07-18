//package kg.erkin.springbackend;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.spec.SecretKeySpec;
//import javax.xml.bind.DatatypeConverter;
//import java.security.Key;
//import java.sql.Date;
//import java.time.Instant;
//
//import static io.jsonwebtoken.Jwts.parser;
//import static java.util.Date.from;
//
//@Component
//@RequiredArgsConstructor
//public class JwtProvider {
//    @Value("${jwt.secret.key}")
//    private String secretKey;
//    @Value("${jwt.expiration.time}")
//    private Long jwtExpirationInMillis;
//
//
//    //The JWT signature algorithm we will be using to sign the token
//    private SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//
//    public String generateToken(Authentication authentication) {
//        //We will sign our JWT with our ApiKey secret
//        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
//        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
//
//        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
//        return Jwts.builder()
//                .setSubject(principal.getUsername())
//                .setIssuedAt(from(Instant.now()))
//                .signWith(signatureAlgorithm, signingKey)
//                .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis)))
//                .compact();
//    }
//
//    public String generateTokenWithUserName(String username) {
//
//        //We will sign our JWT with our ApiKey secret
//        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
//        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
//
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(from(Instant.now()))
//                .signWith(signatureAlgorithm, signingKey)
//                .setExpiration(Date.from(Instant.now().plusMillis(jwtExpirationInMillis)))
//                .compact();
//    }
//
//    public boolean validateToken(String jwt) {
//        //We will sign our JWT with our ApiKey secret
//        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
//        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
//
//        Jws<Claims> claimsJws = parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey)).parseClaimsJws(jwt);
//        return true;
//    }
//
//
//    public String getUsernameFromJwt(String token) {
//        Claims claims = parser()
//                .setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
//                .parseClaimsJws(token)
//                .getBody();
//
//        return claims.getSubject();
//    }
//
//    public Long getJwtExpirationInMillis() {
//        return jwtExpirationInMillis;
//    }
//}
