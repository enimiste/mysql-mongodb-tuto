package com.example.mysqlmongodb.backend.repositories;

import com.example.mysqlmongodb.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
