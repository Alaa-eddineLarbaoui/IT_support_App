package com.example.IT.support.App.Repository;

import com.example.IT.support.App.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {
     User findByUsername(String Username);
}
