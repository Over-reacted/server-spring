package us.overreacted.serverspring.service;

import us.overreacted.serverspring.model.request.LoginRequest;
import us.overreacted.serverspring.model.request.RegisterRequest;

/**
 * @author Murad Hamza on 14.10.2020 г.
 */
public interface UserService {
    String login(LoginRequest loginRequest);

    String registerUser(RegisterRequest registerRequest);
}
