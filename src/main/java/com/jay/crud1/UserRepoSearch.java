package com.jay.crud1;

import com.jay.crud1.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepoSearch extends JpaRepository<User, Long > {
    @Query("SELECT p FROM User p WHERE p.name LIKE %?1%"   )
    public List<User> search(String keyword);

}
