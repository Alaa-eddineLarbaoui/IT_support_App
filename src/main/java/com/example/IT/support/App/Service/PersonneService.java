package com.example.IT.support.App.Service;

import com.example.IT.support.App.Model.Admin;
import com.example.IT.support.App.Model.Person;
import com.example.IT.support.App.Model.TechnicienIT;
import com.example.IT.support.App.Model.User;
import com.example.IT.support.App.Repository.PersoneRepository;
import com.example.IT.support.App.dto.SingUpDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonneService {
    @Autowired
    private PersoneRepository personeRepository;


    private final PasswordEncoder passwordEncoder;

    public String register(SingUpDto request) {
        Person person = createUserByRole(request);
        personeRepository.save(person);
        return "person signup";
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
