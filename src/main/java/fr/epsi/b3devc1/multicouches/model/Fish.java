package fr.epsi.b3devc1.multicouches.model;

import jakarta.persistence.*;

@Entity
public class Fish extends Animal {

    @Enumerated(EnumType.STRING)
    private FishLivEnv livingEnv;

    @ManyToOne
    @JoinColumn(name = "petstore_id")
    private PetStore petStore;


    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }


    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }
}
