package dev.venkat.runners.security;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO map(UserDO userDO) {
        UserDTO userDTO = new UserDTO(userDO.getId(), userDO.getUsername(), userDO.getPassword());
        return userDTO;
    }

    public UserDO map(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        userDO.setId(userDTO.id());
        userDO.setUsername(userDTO.username());
        userDO.setPassword(userDTO.password());
        return userDO;
    }
}
