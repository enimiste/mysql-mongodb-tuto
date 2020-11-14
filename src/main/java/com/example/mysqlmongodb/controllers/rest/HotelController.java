package com.example.mysqlmongodb.controllers.rest;

import com.example.mysqlmongodb.backend.entity.Departement;
import com.example.mysqlmongodb.backend.entity.User;
import com.example.mysqlmongodb.backend.mongo.Hotel;
import com.example.mysqlmongodb.backend.repositories.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hotels")
@RequiredArgsConstructor
public class HotelController {
    private final HotelRepository hotelRepository;

    @GetMapping
    public List<Hotel> all() {
        return hotelRepository.findAll();
    }

    @GetMapping("/{hotelId}")
    public Hotel hotel(@PathVariable("hotelId") String id) {
        return hotelRepository.findById(id)
                .orElse(null);
    }
}
