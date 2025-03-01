package com.security.SecurityLearn.Repository;

import com.security.SecurityLearn.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);

}
