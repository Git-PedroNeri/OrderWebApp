package com.neri.pedro.orderwebapp.modules.user.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "address")
public class Address {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @OneToOne(orphanRemoval = true)
    @MapsId
    private User user;

    public Address(Long id, String street, String city, User user) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.user = user;
    }

    public Address(Long id, String street, String city) {
        this.id = id;
        this.street = street;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}