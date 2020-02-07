package com.remindyou.backend.repository;

import com.remindyou.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    Optional<User> findByUuid(String uuid); //findAllBy i gjen te gjithe uuid-t per te gjithe userat, findByUuid e gjen vetem nje
}
