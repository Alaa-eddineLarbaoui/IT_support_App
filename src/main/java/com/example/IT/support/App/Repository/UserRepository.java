package com.example.IT.support.App.Repository;

import com.example.IT.support.App.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {
    List<User> findByUsername(String Username);
}
