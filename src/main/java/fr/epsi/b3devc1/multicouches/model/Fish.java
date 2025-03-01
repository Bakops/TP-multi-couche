package fr.epsi.b3devc1.multicouches.model;

import jakarta.persistence.*;

@Entity
public class Fish extends Animal {

    @Enumerated(EnumType.STRING)
    private FishLivEnv livingEnv;

    @ManyToOne
    @JoinColumn(name = "petstore_id")
    private PetStore petStore;

    // Getters and Setters

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }
}
