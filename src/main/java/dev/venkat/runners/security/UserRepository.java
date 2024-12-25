package dev.venkat.runners.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDO, Integer> {

    public Optional<UserDO> findByUsername(String username);
    
}
