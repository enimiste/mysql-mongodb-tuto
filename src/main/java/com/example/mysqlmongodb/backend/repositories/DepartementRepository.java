package com.example.mysqlmongodb.backend.repositories;

import com.example.mysqlmongodb.backend.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}
