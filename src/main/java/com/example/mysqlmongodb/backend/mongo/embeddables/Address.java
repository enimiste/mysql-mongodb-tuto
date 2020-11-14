package com.example.mysqlmongodb.backend.mongo.embeddables;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {
    private String city;
    private String country;
}
