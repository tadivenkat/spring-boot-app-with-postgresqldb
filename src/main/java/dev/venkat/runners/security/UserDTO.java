package dev.venkat.runners.security;

public record UserDTO (
    Integer id,
    String username,
    String password
) {}
