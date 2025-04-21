package lunab.adopet.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lunab.adopet.api.domain.user.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }

    public String gerarToken(UserData user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Rest AdoPet")
                    .withSubject(user.getUsername())
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar o token", e);
        }
    }

    public String getSubject(String tokenJWT) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT decodedJWT = JWT.require(algorithm)
                    .withIssuer("API Rest AdoPet")
                    .build()
                    .verify(tokenJWT);
            return decodedJWT.getSubject();
        } catch (Exception e) {
            System.out.println("ERRO NA VALIDAÇÃO: " + e.getMessage());
            throw e;
        }
    }
}
