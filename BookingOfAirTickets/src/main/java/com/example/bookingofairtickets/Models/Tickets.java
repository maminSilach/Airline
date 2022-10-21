package com.example.bookingofairtickets.Models;


import javax.persistence.*;


@Entity
@Table(name = "tickets")

public class Tickets {

    public Tickets() {
    }

    public Tickets(String name, String email,String time, String type, String fromCity, String toCity, String fromCountry,
                   String toCountry, String price) {
        this.name = name;
        this.email = email;
        this.time = time;
        this.type = type;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.fromCountry = fromCountry;
        this.toCountry = toCountry;
        this.price = price;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Column(name = "name")
     String name;
    @Column(name = "email")
    String email;
    @Column(name = "time")
    String time;
    @Column(name = "type")
    String type;
    @Column(name = "from_city")
    String fromCity;
    @Column(name = "to_city")
    String toCity;
    @Column(name = "from_country")
    String fromCountry;
    @Column(name = "to_country")
    String toCountry;
    @Column(name = "price")
    String price;



    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getFromCountry() {
        return fromCountry;
    }

    public void setFromCountry(String fromCountry) {
        this.fromCountry = fromCountry;
    }

    public String getToCountry() {
        return toCountry;
    }

    public void setToCountry(String toCountry) {
        this.toCountry = toCountry;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", time='" + time + '\'' +
                ", type='" + type + '\'' +
                ", fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", fromCountry='" + fromCountry + '\'' +
                ", toCountry='" + toCountry + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
