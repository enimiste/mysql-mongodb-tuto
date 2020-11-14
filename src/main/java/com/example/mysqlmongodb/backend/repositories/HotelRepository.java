package com.example.mysqlmongodb.backend.repositories;

import com.example.mysqlmongodb.backend.mongo.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
    List<Hotel> findByPricePerNightGreaterThan(int value);

    List<Hotel> findByPricePerNightLessThan(int value);

    Page<Hotel> findByPricePerNightGreaterThan(int value, Pageable pageable);

    Page<Hotel> findByPricePerNightLessThan(int value, Pageable pageable);

    List<Hotel> filterByReviewsRatingGreaterThan(int value);

    default List<Hotel> filterByReviewsRatingLessThan(int value) {
        //here we will use query dsl
        return Collections.emptyList();
    }
}
