package com.example.IT.support.App.Controller;

import com.example.IT.support.App.Config.JwtAuth;
import com.example.IT.support.App.Enum.Erole;
import com.example.IT.support.App.Model.Person;
import com.example.IT.support.App.Repository.PersoneRepository;
import com.example.IT.support.App.Service.PersonneService;
import com.example.IT.support.App.Service.UserService;
import com.example.IT.support.App.dto.JwtDto;
import com.example.IT.support.App.dto.LoginPersonDto;
import com.example.IT.support.App.dto.SingUpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthoController {

    private final AuthenticationManager authenticationManager;
    private final PersoneRepository personeRepository;

    private final PersonneService personneService;

    public AuthoController(AuthenticationManager authenticationManager, PersoneRepository personeRepository, PersonneService personneService) {
        this.authenticationManager = authenticationManager;
        this.personeRepository = personeRepository;
        this.personneService = personneService;
    }


    private Person authenticate(Person input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return personeRepository.findByUsername(input.getUsername());
    }
    @PostMapping("/login")
    public JwtDto login(@RequestBody LoginPersonDto loginPersonDto) {
        System.out.println("eeeeeeeeeeeeeeeee");

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginPersonDto.getUsername(), loginPersonDto.getPassword())
        );
        System.out.println("rrrrrrrrrrrrrrrrrrrrrr");
        Person person1 = personeRepository.findByUsername(loginPersonDto.getUsername());
        Erole role= person1.getRole();
        long userId = person1.getId();
        String token = JwtAuth.generateToken(loginPersonDto.getUsername(),role);
        return new JwtDto(userId , token);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SingUpDto singUpDto){
        return ResponseEntity.ok(personneService.register(singUpDto));
    }


}
