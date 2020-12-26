package com.jay.crud1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    //	@Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
//			+ " OR p.brand LIKE %?1%"
//			+ " OR p.madein LIKE %?1%"
//			+ " OR CONCAT(p.price, '') LIKE %?1%")
    @Query("SELECT u FROM User u WHERE CONCAT(u.name, ' ', u.email, ' ', u.role) LIKE %?1%")
    public List<User> search(String keyword);
}
