package com.example.IT.support.App.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
    private long user_id;
    private long panne_id;
    private long equipement_id;
}
