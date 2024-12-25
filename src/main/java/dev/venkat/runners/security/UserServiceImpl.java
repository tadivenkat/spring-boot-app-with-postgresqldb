package dev.venkat.runners.security;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public UserDTO create(String username, String password) {
        UserDTO user = new UserDTO(null, username, passwordEncoder.encode(password));
        return userMapper.map(userRepository.saveAndFlush(userMapper.map(user)));
    }

    @Override
    public UserDTO create(UserDTO user) {
        return create(user.username(), user.password());
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(userMapper::map).toList();
    }

    @Override
    public UserDTO findById(Integer id) {
        return userRepository.findById(id).map(userMapper::map).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public UserDTO findByUsername(String username) {
        return userRepository.findByUsername(username).map(userMapper::map)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }

    @Override
    public UserDTO update(Integer id, UserDTO user) {
        UserDO existingUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        existingUser.setUsername(user.username());
        existingUser.setPassword(user.password());
        return userMapper.map(userRepository.saveAndFlush(existingUser));
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
