package fr.epsi.b3devc1.multicouches.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date birth;
    private String couleur;

    @ManyToOne
    @JoinColumn(name = "petstore_id")
    private PetStore petStore;


    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }


    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }
}
