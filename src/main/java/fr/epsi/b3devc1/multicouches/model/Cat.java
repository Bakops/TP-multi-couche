package fr.epsi.b3devc1.multicouches.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cat")
public class Cat extends Animal {

    private String chipId;


    public void setChipId(String chipId) {
        this.chipId = chipId;
    }
}
