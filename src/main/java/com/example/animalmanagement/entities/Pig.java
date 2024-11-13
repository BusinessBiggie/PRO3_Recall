package com.example.animalmanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Pig implements Serializable {

  private long animalId;

  private BigDecimal weightKilogram;

  private String name;

  // Default no-args constructor, required by JPA
  public Pig() {
    this.weightKilogram = BigDecimal.ZERO;
    this.name = "";
  }

  public Pig(BigDecimal weightKilogram, String name) {
    this.weightKilogram = weightKilogram;
    this.name = name;
  }

  // Getters and Setters
  public long getAnimalId() {
    return animalId;
  }

  public void setAnimalId(long animal_id) {
    this.animalId = animal_id;
  }

  public BigDecimal getweightKilogram() {
    return weightKilogram;
  }

  public void setweightKilogram(BigDecimal weightKilogram) {
    this.weightKilogram = weightKilogram;
  }

  // Override equals, hashCode, and toString
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pig pig = (Pig) o;
    return animalId == pig.animalId &&
        Objects.equals(weightKilogram, pig.weightKilogram);
  }

  @Override
  public int hashCode() {
    return Objects.hash(animalId, weightKilogram);
  }

  @Override
  public String toString() {
    return "Animal{" +
        "animal_id=" + animalId +
        ", weightKilogram=" + weightKilogram +
        '}';
  }
}
