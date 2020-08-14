package com.aaryadewa.dev.entity;

import java.util.UUID;

public class Product {
  private final UUID id;
  private String name;
  private String description;

  public Product() {
    this.id = UUID.randomUUID();
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}