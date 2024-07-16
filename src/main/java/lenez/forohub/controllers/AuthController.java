package lenez.forohub.controllers;

import jakarta.validation.Valid;
import lenez.forohub.domain.user.AuthUser;
import lenez.forohub.domain.user.User;
import lenez.forohub.security.JWTTokenData;
import lenez.forohub.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authUser(@RequestBody @Valid AuthUser authUser) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(authUser.email(),
                authUser.password());
        System.out.println(authToken);
        System.out.println(authUser.email() + " \n" + authUser.password());
        var authenticatedUser = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generateToken((User) authenticatedUser.getPrincipal());
        return ResponseEntity.ok(new JWTTokenData(JWTtoken));
    }

}
