package security.jwt.oauth2.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import security.jwt.oauth2.entity.User;
import security.jwt.oauth2.repository.UserRepository;
import security.jwt.oauth2.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findUserById(id).orElse(null);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User userDetail) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(userDetail.getUsername());
            user.setPassword(userDetail.getPassword());
            return userRepository.save(user);
        }).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        return userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }

}
