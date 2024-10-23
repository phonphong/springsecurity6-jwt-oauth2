package security.jwt.oauth2.service;

import security.jwt.oauth2.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);

    List<User> getAllUser();

    User saveUser(User user);

    User updateUser(Long id, User userDetail);

    boolean deleteById(Long id);
}
