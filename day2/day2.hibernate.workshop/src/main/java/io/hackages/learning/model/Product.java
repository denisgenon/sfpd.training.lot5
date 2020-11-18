package io.hackages.learning.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 64, nullable = false, unique = true)
    private String name;

    @Column
    private float price;

    @Enumerated(EnumType.STRING)
    @Column
    private ProductCategory productCategory;

    @Column
    private LocalDate createdAt;

    @Column
    private LocalDateTime updatedAt;

    public Product() {
        createdAt = LocalDate.now();
        updatedAt = LocalDateTime.now();
    }

    public Product(String name, float price) {
        this(name, price, ProductCategory.CAT_FOOD);
    }

    public Product(String name, float price, ProductCategory productCategory) {
        this();
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
