package fr.epsi.b3devc1.multicouches.model;

import jakarta.persistence.*;

@Entity
@Table(name = "petstore")
public class PetStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String managerName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;


    public void setName(String name) {
        this.name = name;
    }


    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }


    public void setAddress(Address address) {
        this.address = address;
    }

    public void setLivingEnv(FishLivEnv fishLivEnv) {
    }
}
