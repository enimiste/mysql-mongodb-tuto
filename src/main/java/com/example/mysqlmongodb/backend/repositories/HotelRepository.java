package com.example.mysqlmongodb.backend.repositories;

import com.example.mysqlmongodb.backend.mongo.Hotel;
import com.example.mysqlmongodb.backend.mongo.QHotel;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String>, QuerydslPredicateExecutor<Hotel> {
    List<Hotel> findByPricePerNightGreaterThan(int value);

    List<Hotel> findByPricePerNightLessThan(int value);

    Page<Hotel> findByPricePerNightGreaterThan(int value, Pageable pageable);

    Page<Hotel> findByPricePerNightLessThan(int value, Pageable pageable);

    default List<Hotel> filterByReviewsRatingGreaterThan(int value){
        QHotel hotel = QHotel.hotel;
        BooleanExpression reviewsRatingLessThan = hotel.reviews.any().rating.gt(value);
        return (List<Hotel>) findAll(reviewsRatingLessThan);
    }

    default List<Hotel> filterByReviewsRatingLessThan(int value) {
        QHotel hotel = QHotel.hotel;
        BooleanExpression reviewsRatingLessThan = hotel.reviews.any().rating.lt(value);
        return (List<Hotel>) findAll(reviewsRatingLessThan);
    }
}
