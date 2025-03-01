package fr.epsi.b3devc1.multicouches.service;

import fr.epsi.b3devc1.multicouches.model.Animal;
import fr.epsi.b3devc1.multicouches.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {


    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id).orElse(null);
    }

    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> getAnimalsByPetStoreId(Long petStoreId) {
        return animalRepository.findByPetStoreId(petStoreId);
    }
}
