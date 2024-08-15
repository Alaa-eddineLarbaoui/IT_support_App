package com.example.IT.support.App.Controller;

import com.example.IT.support.App.Config.JwtAuth;
import com.example.IT.support.App.Enum.Erole;
import com.example.IT.support.App.Model.Person;
import com.example.IT.support.App.Repository.PersoneRepository;
import com.example.IT.support.App.Service.PersonneService;
import com.example.IT.support.App.Service.UserService;
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

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PersoneRepository personeRepository;

    @Autowired
    private PersonneService personneService;



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
    public ResponseEntity<?> login(@RequestBody LoginPersonDto loginPersonDto) {
        System.out.println("eeeeeeeeeeeeeeeee");

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginPersonDto.getUsername(), loginPersonDto.getPassword())
        );
        System.out.println("rrrrrrrrrrrrrrrrrrrrrr");
        Person person1 = personeRepository.findByUsername(loginPersonDto.getUsername());
        Erole role= person1.getRole();
        String token = JwtAuth.generateToken(loginPersonDto.getUsername(),role);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Map<String, String> response = new HashMap<>();
        System.out.println("tttttttttttttttttttttttttt");
        response.put("token", token);
        response.put("role",role.name());
        response.put("id",person1.getId().toString());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SingUpDto singUpDto){
        return ResponseEntity.ok(personneService.register(singUpDto));
    }


}
