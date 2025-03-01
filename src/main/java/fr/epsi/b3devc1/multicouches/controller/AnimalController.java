package fr.epsi.b3devc1.multicouches.controller;

import fr.epsi.b3devc1.multicouches.model.Animal;
import fr.epsi.b3devc1.multicouches.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Long id) {
        return animalService.getAnimalById(id);
    }

    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalService.saveAnimal(animal);
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        animal.setId(id);
        return animalService.saveAnimal(animal);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
    }

    @GetMapping("/petstore/{petStoreId}")
    public List<Animal> getAnimalsByPetStoreId(@PathVariable Long petStoreId) {
        return animalService.getAnimalsByPetStoreId(petStoreId);
    }
}
