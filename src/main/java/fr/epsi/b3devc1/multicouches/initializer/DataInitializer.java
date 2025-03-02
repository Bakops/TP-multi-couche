package fr.epsi.b3devc1.multicouches.initializer;

import fr.epsi.b3devc1.multicouches.model.*;
import fr.epsi.b3devc1.multicouches.repository.AnimalRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    private final AnimalRepository animalRepository;

    public DataInitializer(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        try {
            for (int i = 1; i <= 3; i++) {

                Address address = new Address();
                address.setNumber(String.valueOf(i));
                address.setStreet("Rue Jean Jaures " + i);
                address.setZipCode("4400" + i);
                address.setCity("Nantes " + i);
                entityManager.persist(address);

                PetStore petStore = new PetStore();
                petStore.setName("PetStore" + i);
                petStore.setManagerName("Admin" + i);
                petStore.setAddress(address);
                petStore.setLivingEnv(FishLivEnv.FRESH_WATER);
                entityManager.persist(petStore);

                Product product = new Product();
                product.setCode("P00" + i);
                product.setLabel("Product" + i);
                product.setType(ProdType.FOOD);
                product.setPrice(10.0 * i);
                product.setPetStore(petStore);
                entityManager.persist(product);

                Fish fish = new Fish();
                fish.setBirth(new Date());
                fish.setCouleur("Color " + i);
                fish.setLivingEnv(FishLivEnv.FRESH_WATER);
                fish.setPetStore(petStore);
                entityManager.persist(fish);

                Cat cat = new Cat();
                cat.setBirth(new Date());
                cat.setCouleur("Color " + i);
                cat.setChipId("C" + i);
                cat.setPetStore(petStore);
                entityManager.persist(cat);
            }

            displayData();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void displayData() {
        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a", Address.class).getResultList();
        System.out.println("Addresses:");
        for (Address address : addresses) {
            System.out.println(address);
        }

        List<PetStore> petStores = entityManager.createQuery("SELECT p FROM PetStore p", PetStore.class).getResultList();
        System.out.println("PetStores:");
        for (PetStore petStore : petStores) {
            System.out.println(petStore);
        }

        List<Product> products = entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println(product);
        }

        List<Animal> animals = animalRepository.findAll();
        System.out.println("Animals:");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
