package com.example.animalmanagement.repositories;

import com.example.animalmanagement.entities.Pig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PigRepository extends JpaRepository<Pig, Long> {
}
