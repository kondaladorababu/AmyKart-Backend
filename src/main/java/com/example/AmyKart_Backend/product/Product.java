package com.example.AmyKart_Backend.product;

import com.example.AmyKart_Backend.rating.Rating;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String title;
    private double price;
    private String description;
    private String category;

    @Lob
    private byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id")
    private Rating rating;

    public Product() {
    }

    public Product(String title, double price, String description, String category, byte[] image, Rating rating) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                '}';
    }
}

    //
    //and sql query for rating table
//    CREATE TABLE rating (
//    id INT AUTO_INCREMENT PRIMARY KEY,
//    rate DOUBLE,
//    count INT
//    )

//    how to store the image  in db
//    CREATE TABLE product (
//    id INT AUTO_INCREMENT PRIMARY KEY,
//    title VARCHAR(255),
//    price DOUBLE,
//    description VARCHAR(255),
//    category VARCHAR(255),
//    image BLOB,
//    rating_id INT,
//    FOREIGN KEY (rating_id) REFERENCES rating(id)
//            )

