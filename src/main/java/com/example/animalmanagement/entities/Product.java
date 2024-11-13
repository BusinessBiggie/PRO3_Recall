package com.example.animalmanagement.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "max_weight", nullable = false)
  private BigDecimal maxWeight;

  @Column(name = "is_sent", nullable = false)
  private Boolean sent;

  @Column(name = "current_weight", nullable = false)
  private BigDecimal currentWeight = BigDecimal.ZERO;

  @Column(name = "part_type", nullable = false)
  private String partType;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "product_id")
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
