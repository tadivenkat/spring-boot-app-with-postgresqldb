package dev.venkat.runners.security;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();
    UserDTO findById(Integer id);
    UserDTO findByUsername(String username);
    UserDTO create(UserDTO user);
    UserDTO update(Integer id, UserDTO user);
    void delete(Integer id);
}
