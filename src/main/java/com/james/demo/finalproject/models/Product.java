package com.james.demo.finalproject.models;



import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class Product {

  @Column(name = "name")
  @NotEmpty
  private String name;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NotEmpty
  private int id;

  @Column(name = "sku")
  @NotEmpty
  private String sku;


  @Column(name = "price")
  @NotEmpty
  private double price;

  @Column(name = "description")
  @NotEmpty
  private String description;

  @Column(name = "size")
  private String size;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  @ManyToOne
  @JoinColumn(name = "collection_id")
  private Collection collection;

  @Column(name = "photo")
  @NotEmpty
  private String photo;

  public String getName() {
    return this.name;
  }


  public void setName(String newName) {
    if (!newName.isEmpty()) {
      this.name = newName;
    }
  }

  public int getId() {
    return this.id;
  }



  public void setId(int newId) {
    this.id = newId;
  }

  public double getPrice() {
    return this.price;
  }

  /**
   * Update the price.

   */

  public void setPrice(double price) {
    this.price = price;
  }

  public String getDescription() {
    return  this.description;
  }

  /**
   * Update the description.

   */

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }
  
  public Category getCategory() {
    return this.category;
  }

  /**
   * Update the product category.

   */
  public void setCategory(Category category) {
    this.category = category;
  }


  public Collection getCollection() {
    return this.collection;
  }

  /**
   * Update the product collection.

   */

  public void setCollection(Collection collection) {
    this.collection = collection;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }
  
  @Override
  public int hashCode() {
    return id;
  }

  /**
   * Update the product collection.

   */
  @Override
  public boolean equals(Object obj) {
    boolean result = false;
    if (obj == null) {
      return result;
    }
    Product other = (Product) obj;
    return (this.id == other.id && this.name == other.name && this.size.equals(other.size)
        && this.collection.getId() == other.collection.getId()
        && this.category.getId() == other.category.getId()
        && this.description == other.description && this.price == other.price);
  }

}
