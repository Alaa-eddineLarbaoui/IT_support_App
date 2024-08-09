package com.example.IT.support.App.dto;

import com.example.IT.support.App.Enum.Erole;
import lombok.Data;

@Data
public class SingUpDto {
    private String username;
    private String password;
    private String email;
    private Erole role;
}
