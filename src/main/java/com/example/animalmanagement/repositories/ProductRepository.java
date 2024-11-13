package com.example.animalmanagement.repositories;


import com.example.animalmanagement.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface ProductRepository extends JpaRepository<Product, Long> {
  /*@Query("SELECT p FROM Product p JOIN p.pigParts pigPart WHERE pigPart.pig.animalId = :pigId")
  List<Product> findAllByPigId(long pigId);*/
}
