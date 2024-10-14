package br.edu.fema.api.tcc.infra;

import br.edu.fema.api.tcc.usuario.model.UsuarioModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

   @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(UsuarioModel usuario){
       //System.out.println(secret);
        try {
            var algoritmo  = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API EPI_FACIL")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token JWT", exception);        }

    }

   public String getSubject(String tokenJWT){
       try{
       var algoritmo  = Algorithm.HMAC256(secret);
       return JWT.require(algoritmo)
               .withIssuer("API EPI_FACIL")
               .build()
               .verify(tokenJWT)
               .getSubject();
   }
       catch (JWTCreationException exception){
           throw new RuntimeException("Token JWT inválido ou expirado");
       }
   }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
