package fr.epsi.b3devc1.multicouches.initializer;

import fr.epsi.b3devc1.multicouches.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataInitializer implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        try {
            // Création de plusieurs adresses et entités associées
            for (int i = 1; i <= 3; i++) {
                // Création de l'adresse
                Address address = new Address();
                address.setNumber(String.valueOf(i));
                address.setStreet("Street " + i);
                address.setZipCode("1234" + i);
                address.setCity("City " + i);
                entityManager.persist(address);

                // Création du PetStore
                PetStore petStore = new PetStore();
                petStore.setName("PetStore" + i);
                petStore.setManagerName("Manager" + i);
                petStore.setAddress(address);
                petStore.setLivingEnv(FishLivEnv.FRESH_WATER);
                entityManager.persist(petStore);

                // Création d'un produit
                Product product = new Product();
                product.setCode("P00" + i);
                product.setLabel("Product" + i);
                product.setType(ProdType.FOOD);
                product.setPrice(10.0 * i);
                product.setPetStore(petStore);
                entityManager.persist(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e; // Relancez l'exception pour voir le message d'erreur complet
        }
    }
}
