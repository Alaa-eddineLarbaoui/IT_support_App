package com.example.IT.support.App.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JwtDto {
    private long user_id;
    private String token;
}
