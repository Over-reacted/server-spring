package eu.overreacted.serverspring.service;

import io.fusionauth.jwt.JWTDecoder;
import io.fusionauth.jwt.JWTEncoder;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACSigner;
import io.fusionauth.jwt.hmac.HMACVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * @author Murad Hamza on 14.10.2020 г.
 */
@Service
public class JwtService {

    private final HMACSigner singer;
    private final JWTEncoder encoder;
    private final JWTDecoder decoder;
    private final HMACVerifier verifier;

    public JwtService(@Value("{jwt.secret:ASDA}") final String jwtSecret) {
        this.singer = HMACSigner.newSHA256Signer(jwtSecret);
        this.verifier = HMACVerifier.newVerifier(jwtSecret);
        this.encoder = JWT.getEncoder();
        this.decoder = JWT.getDecoder();
    }

    public String sign(final String id, final Integer hours) {
        final JWT jwt = new JWT()
                .setExpiration(ZonedDateTime.now(ZoneOffset.UTC).plusHours(hours))
                .setIssuedAt(ZonedDateTime.now(ZoneOffset.UTC));
        jwt.getOtherClaims().put("id", id);

        return encoder.encode(jwt, singer);
    }

    public String getIdFromToken(final String token) {
        final JWT decode;
        try {
            decode = decoder.decode(token, verifier);
        } catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }

        if (decode.isExpired()) {
            return null;
        }

        return (String) decode.getOtherClaims().get("id");
    }
}
