package security.jwt.oauth2.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import security.jwt.oauth2.entity.Role;
import security.jwt.oauth2.entity.Token;
import security.jwt.oauth2.entity.User;
import security.jwt.oauth2.mapper.UserMapper;
import security.jwt.oauth2.model.AuthenticationRequest;
import security.jwt.oauth2.model.AuthenticationResponse;
import security.jwt.oauth2.model.RegisterResquest;
import security.jwt.oauth2.repository.TokenRepository;
import security.jwt.oauth2.repository.UserRepository;
import security.jwt.oauth2.service.AuthenticationService;
import security.jwt.oauth2.service.JwtService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final JwtService jwtService;

    @Override
    public AuthenticationResponse register(RegisterResquest resquest) {

        User user = new User();
        user.setUsername(resquest.getUsername());
        user.setPassword(resquest.getPassword());
        user.setRole(Role.ADMIN);

        User addUser = userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        // save token db
        Token token = Token.builder()
                .userId(user.getId())
                .Token(jwtToken)
                .expried(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
        return AuthenticationResponse.builder()
                .userDto(UserMapper.mapUserDto(addUser))
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {
        return null;
    }
}
