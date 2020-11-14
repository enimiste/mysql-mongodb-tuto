package com.example.mysqlmongodb.controllers.rest;

import com.example.mysqlmongodb.backend.entity.Departement;
import com.example.mysqlmongodb.backend.entity.User;
import com.example.mysqlmongodb.backend.mongo.Hotel;
import com.example.mysqlmongodb.backend.repositories.HotelRepository;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

@RestController
@RequestMapping("hotels")
@RequiredArgsConstructor
public class HotelController {
    private final HotelRepository hotelRepository;

    @GetMapping
    public List<Hotel> all() {
        return hotelRepository.findAll();
    }

    @GetMapping("/paged")
    public Page<Hotel> allPaged() {
        return hotelRepository.findAll(Pageable.unpaged());
    }

    @GetMapping("/{hotelId}")
    public Hotel hotel(@PathVariable("hotelId") String id) {
        return hotelRepository.findById(id)
                .orElse(null);
    }

    @GetMapping("/filter-by-price/{cmp}/{value}")
    public List<Hotel> hotelsByPrices(@NotNull @PathVariable("cmp") String cmp, @PathVariable("value") int value) {
        if ("gt".equalsIgnoreCase(cmp))
            return hotelRepository.findByPricePerNightGreaterThan(value);
        else if ("lt".equalsIgnoreCase(cmp))
            return hotelRepository.findByPricePerNightLessThan(value);
        else
            return emptyList();
    }

    @GetMapping("/filter-by-rating/{cmp}/{value}")
    public List<Hotel> hotelsByRating(@NotNull @PathVariable("cmp") String cmp, @PathVariable("value") int value) {
        if ("gt".equalsIgnoreCase(cmp))
            return hotelRepository.filterByReviewsRatingGreaterThan(value);
        else if ("lt".equalsIgnoreCase(cmp))
            return hotelRepository.filterByReviewsRatingLessThan(value);
        else
            return emptyList();
    }

    @GetMapping("/paged/filter-by-price/{cmp}/{value}")
    public Page<Hotel> hotelsByPricesPaged(@NotNull @PathVariable("cmp") String cmp, @PathVariable("value") int value) {
        if ("gt".equalsIgnoreCase(cmp))
            return hotelRepository.findByPricePerNightGreaterThan(value, Pageable.unpaged());
        else if ("lt".equalsIgnoreCase(cmp))
            return hotelRepository.findByPricePerNightLessThan(value, Pageable.unpaged());
        else
            return Page.empty();
    }
}
