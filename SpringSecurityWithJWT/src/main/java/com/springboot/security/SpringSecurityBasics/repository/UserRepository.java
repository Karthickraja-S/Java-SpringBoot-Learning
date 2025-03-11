package com.springboot.security.SpringSecurityBasics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.security.SpringSecurityBasics.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    // Considering UserName is unique. Just for Learning Project !
    public User findByUsername(String username);
}
