package security.jwt.oauth2.service;

import security.jwt.oauth2.entity.User;

public interface JwtService {
    String generateToken(User user);

}
