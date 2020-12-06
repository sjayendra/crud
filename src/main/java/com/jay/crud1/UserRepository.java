package com.jay.crud1;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jay.crud1.User;

import java.util.Optional;

public interface UserRepository extends  JpaRepository<User, Long>{
}
