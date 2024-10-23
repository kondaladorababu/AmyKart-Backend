package com.example.AmyKart_Backend.rating;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private double rate;
    private int count;

    //default constructor
    public Rating() {
    }

    //parameterized constructor
    public Rating(double rate, int count) {
        this.rate = rate;
        this.count = count;
    }

    //getter and setter methods
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //toString method
    @Override
    public String toString() {
        return "Rating{" +
                "rate=" + rate +
                ", count=" + count +
                '}';
    }

    //sql query
    //CREATE TABLE rating (
    //id INT AUTO_INCREMENT PRIMARY KEY,
    //rate DOUBLE,
    //count INT
    //);

}
