package eu.overreacted.serverspring.service;

import eu.overreacted.serverspring.model.LoginRequest;
import eu.overreacted.serverspring.model.RegisterRequest;

/**
 * @author Murad Hamza on 14.10.2020 г.
 */
public interface UserService {
    String login(LoginRequest loginRequest);

    String registerUser(RegisterRequest registerRequest);
}
