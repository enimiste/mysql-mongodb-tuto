package com.example.mysqlmongodb.backend.mongo.embeddables;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reviews {
    private String comment;
    private int rating;
    private boolean approved;
}
