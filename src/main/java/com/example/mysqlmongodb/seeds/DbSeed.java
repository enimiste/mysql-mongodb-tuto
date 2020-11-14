package com.example.mysqlmongodb.seeds;

import com.example.mysqlmongodb.backend.entity.Departement;
import com.example.mysqlmongodb.backend.entity.User;
import com.example.mysqlmongodb.backend.mongo.Hotel;
import com.example.mysqlmongodb.backend.mongo.embeddables.Address;
import com.example.mysqlmongodb.backend.mongo.embeddables.Reservation;
import com.example.mysqlmongodb.backend.mongo.embeddables.Reviews;
import com.example.mysqlmongodb.backend.repositories.DepartementRepository;
import com.example.mysqlmongodb.backend.repositories.HotelRepository;
import com.example.mysqlmongodb.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

@Component
@RequiredArgsConstructor
public class DbSeed implements CommandLineRunner {
    private final DepartementRepository departementRepository;
    private final UserRepository userRepository;
    private final HotelRepository hotelRepository;

    @Override
    public void run(String... args) throws Exception {
        hotelRepository.deleteAll();
        userRepository.deleteAll();
        departementRepository.deleteAll();

        Departement it = Departement.builder()
                .titre("IT")
                .build();

        departementRepository.save(it);
        User admin = User.builder()
                .username("admin")
                .departement(it)
                .build();

        userRepository.save(admin);

        Hotel sofitel = Hotel.builder()
                .pricePerNight(200)
                .address(
                        Address.builder()
                                .city("Paris")
                                .country("France")
                                .build()
                )
                .reviews(asList(
                        Reviews.builder()
                                .rating(7)
                                .comment("Nothing")
                                .approved(false)
                                .build(),
                        Reviews.builder()
                                .rating(10)
                                .comment("Good")
                                .approved(true)
                                .build()
                ))
                .reservations(singletonList(
                        Reservation.builder()
                                .userId(admin.getId())
                                .date(LocalDate.now().plusDays(10))
                                .nbrPersonnes(1)
                                .build()
                ))
                .build();

        Hotel ibis = Hotel.builder()
                .pricePerNight(120)
                .address(
                        Address.builder()
                                .city("Rabat")
                                .country("Maroc")
                                .build()
                )
                .reviews(singletonList(
                        Reviews.builder()
                                .rating(7)
                                .comment("Nothing")
                                .approved(false)
                                .build()
                ))
                .build();

        Hotel kenzi = Hotel.builder()
                .pricePerNight(40)
                .address(
                        Address.builder()
                                .city("Errachidia")
                                .country("Maroc")
                                .build()
                )
                .reviews(singletonList(
                        Reviews.builder()
                                .rating(3)
                                .comment("Médiocre")
                                .approved(false)
                                .build()
                ))
                .build();

        hotelRepository.saveAll(asList(sofitel, ibis, kenzi));
    }
}
