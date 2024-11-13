package com.example.animalmanagement.entities;

import jakarta.persistence.*;

public class PigPart {
  private Long id;
  private Pig pig;
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
