package fr.epsi.b3devc1.multicouches.model;

import jakarta.persistence.*;


@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String street;
    private String zipCode;
    private String city;


    public void setNumber(String number) {
        this.number = number;
    }


    public void setStreet(String street) {
        this.street = street;
    }


    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }



    public void setCity(String city) {
        this.city = city;
    }
}
