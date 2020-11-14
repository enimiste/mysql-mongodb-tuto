package com.example.mysqlmongodb.backend.mongo.embeddables;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {
    private Integer userId;
    private LocalDate date;
    private int nbrPersonnes;
}
