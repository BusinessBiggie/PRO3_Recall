package com.example.animalmanagement.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pig_part")
public class PigPart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "pig_id", nullable = false)
  private Pig pig;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  // Additional fields like weight, etc.

  public Pig getPig() {
    return pig;
  }

  public void setPig(Pig pig) {
    this.pig = pig;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }
}
