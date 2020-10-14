package us.overreacted.serverspring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.overreacted.serverspring.model.request.TokenResponse;
import us.overreacted.serverspring.model.response.LoginRequest;
import us.overreacted.serverspring.model.response.RegisterRequest;
import us.overreacted.serverspring.service.JwtService;
import us.overreacted.serverspring.service.UserService;

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
