package security.jwt.oauth2.service;

import security.jwt.oauth2.model.AuthenticationRequest;
import security.jwt.oauth2.model.AuthenticationResponse;
import security.jwt.oauth2.model.RegisterResquest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterResquest resquest);

    AuthenticationResponse login(AuthenticationRequest request);
}
