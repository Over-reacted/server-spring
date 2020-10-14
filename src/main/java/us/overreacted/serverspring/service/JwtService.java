package us.overreacted.serverspring.service;

/**
 * @author Murad Hamza on 14.10.2020 г.
 */
public interface JwtService {
    String sign(String id, Integer hours);

    String getIdFromToken(String token);
}
