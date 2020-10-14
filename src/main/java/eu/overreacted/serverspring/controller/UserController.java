package eu.overreacted.serverspring.controller;

import eu.overreacted.serverspring.model.LoginRequest;
import eu.overreacted.serverspring.model.RegisterRequest;
import eu.overreacted.serverspring.model.TokenResponse;
import eu.overreacted.serverspring.service.JwtService;
import eu.overreacted.serverspring.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Murad Hamza on 14.10.2020 г.
 */
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    public UserController(final UserService userService, final JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/signup")
    public ResponseEntity<TokenResponse> signup(@Valid @RequestBody final RegisterRequest registerRequest) {
        final String id = userService.registerUser(registerRequest);

        return ResponseEntity.ok(new TokenResponse(jwtService.sign(id, 24), id));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody final LoginRequest loginRequest) {
        final String id = userService.login(loginRequest);

        return ResponseEntity.ok(new TokenResponse(jwtService.sign(id, 24), id));
    }

}
