package com.example.mysqlmongodb.backend.mongo;

import com.example.mysqlmongodb.backend.mongo.embeddables.Address;
import com.example.mysqlmongodb.backend.mongo.embeddables.Reservation;
import com.example.mysqlmongodb.backend.mongo.embeddables.Reviews;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "HOTELS")
@Getter
@AllArgsConstructor
@Builder
public class Hotel {
    @Id
    private String id;
    @Indexed(direction = IndexDirection.ASCENDING)
    private int pricePerNight;
    private Address address;
    private List<Reviews> reviews;

    /*
    You should avoid linking entities from the entity package with those from mongo
    You should use ids with some information if you want to avoid reading data via id
    The correct and updated data should be loaded using ids
     */
    private List<Reservation> reservations;

    public Hotel() {
        reviews = new ArrayList<>();
        reservations = new ArrayList<>();
    }
}
