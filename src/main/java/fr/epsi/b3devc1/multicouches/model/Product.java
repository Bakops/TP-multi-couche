package fr.epsi.b3devc1.multicouches.model;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String label;

    @Enumerated(EnumType.STRING)
    private ProdType type;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "petstore_id")
    private PetStore petStore;




    public void setCode(String code) {
        this.code = code;
    }


    public void setLabel(String label) {
        this.label = label;
    }


    public void setType(ProdType type) {
        this.type = type;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }
}
