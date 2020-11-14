package com.example.mysqlmongodb.backend.repositories;

import com.example.mysqlmongodb.backend.mongo.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
}
