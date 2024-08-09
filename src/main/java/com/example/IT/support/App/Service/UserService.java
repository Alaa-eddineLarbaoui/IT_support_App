package com.example.IT.support.App.Service;
import com.example.IT.support.App.Model.Admin;
import com.example.IT.support.App.Model.Person;
import com.example.IT.support.App.Model.TechnicienIT;
import com.example.IT.support.App.Model.User;
import com.example.IT.support.App.Repository.PersoneRepository;
import com.example.IT.support.App.Repository.UserRepository;
import com.example.IT.support.App.dto.SingUpDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.IT.support.App.Enum.Erole.ADMIN;
import static com.example.IT.support.App.Enum.Erole.TECHNICIEN;


@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersoneRepository repository;

    private final PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public String register(SingUpDto request) {
        Person user = createUserByRole(request);
        repository.save(user);
        return "User signup";
    }

    private Person createUserByRole(SingUpDto request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        Person person = switch (request.getRole()) {
            case ADMIN -> new Admin();
            case TECHNICIEN -> new TechnicienIT();
            default -> new User();
        };

        person.setUsername(request.getUsername());
        person.setEmail(request.getEmail());
        person.setPassword(encodedPassword);
        person.setRole(request.getRole());

        return person;
    }
}
