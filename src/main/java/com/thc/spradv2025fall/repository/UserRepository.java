package com.thc.spradv2025fall.repository;

import com.thc.spradv2025fall.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);

    //List<User> findByPhone(String phone);
}
