package com.jay.crud1;

import com.jay.crud1.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface UserRepo extends PagingAndSortingRepository <User , Long> {
    //@Query("SELECT id FROM users ")
    //List<User> findAll( Pageable pageable);

}
