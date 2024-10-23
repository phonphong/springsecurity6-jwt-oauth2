package security.jwt.oauth2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import security.jwt.oauth2.model.AuthenticationResponse;
import security.jwt.oauth2.model.RegisterResquest;
import security.jwt.oauth2.service.Impl.AuthenticationServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationServiceImpl authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterResquest registerResquest) {
        AuthenticationResponse response = authenticationService.register(registerResquest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
