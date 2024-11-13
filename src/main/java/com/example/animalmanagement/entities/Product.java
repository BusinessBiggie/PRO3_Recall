package com.example.animalmanagement.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {

  private Long id;
  private BigDecimal maxWeight;

  private Boolean sent;

  private BigDecimal currentWeight = BigDecimal.ZERO;

  private String partType;

  private List<PigPart> pigParts = new ArrayList<>();

  // Constructors
  public Product() {
  }

  public Product(BigDecimal maxWeight, String partType) {
    this.maxWeight = maxWeight;
    this.partType = partType;
    sent = false;
  }

  public Boolean getSent()
  {
    return sent;
  }

  public void setSent(Boolean sent)
  {
    this.sent = sent;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BigDecimal getMaxWeight() {
    return maxWeight;
  }

  public void setMaxWeight(BigDecimal maxWeight) {
    this.maxWeight = maxWeight;
  }

  public BigDecimal getCurrentWeight() {
    return currentWeight;
  }

  public void setCurrentWeight(BigDecimal currentWeight) {
    this.currentWeight = currentWeight;
  }

  public List<PigPart> getPigParts() {
    return pigParts;
  }


  public String getPartType() {
    return partType;
  }

  public void setPartType(String partType) {
    this.partType = partType;
  }






  // Override equals and hashCode
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Objects.equals(id, product.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", maxWeight=" + maxWeight +
        ", currentWeight=" + currentWeight +
        ", partType='" + partType + '\'' +
        ", pigParts=" + pigParts +
        '}';
  }
}
