package com.example.bookingofairtickets.Models;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "flights")

public class Flights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "time")
    @Pattern(regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]",message = "Веедите время в формате 'HH:MM'")
    String time;
    @Column(name = "type")
            @Pattern(regexp = "(Бизнес)|(Эконом)",message = "Укажите \"Бизнес\" или \"Эконом\"")
    String type;
    @Column(name = "from_city")
    @NotBlank(message = "Поле не может быть пустым")
    String fromCity;
    @Column(name = "to_city")
    @NotBlank(message = "Поле не может быть пустым")
    String toCity;
    @Column(name = "from_country")
    @NotBlank(message = "Поле не может быть пустым")
    String fromCountry;
    @Column(name = "to_country")
    @NotBlank(message = "Поле не может быть пустым")
    String toCountry;
    @Column(name = "price")
    @Pattern(regexp = "(\\d+\\$)",message = "Укажите цену в $")
    String price;
    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    public Flights() {
    }

    public Flights(String time, String type, String fromCity, String toCity,
                   String fromCountry, String toCountry, String price,User user) {
        this.time = time;
        this.type = type;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.fromCountry = fromCountry;
        this.toCountry = toCountry;
        this.price = price;
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "id=" + id +
                '}';
    }
}
