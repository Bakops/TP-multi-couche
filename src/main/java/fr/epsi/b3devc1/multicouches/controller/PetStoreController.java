package fr.epsi.b3devc1.multicouches.controller;

import fr.epsi.b3devc1.multicouches.model.PetStore;
import fr.epsi.b3devc1.multicouches.service.PetStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petstores")
public class PetStoreController {

    @Autowired
    private PetStoreService petStoreService;

    @GetMapping
    public List<PetStore> getAllPetStores() {
        return petStoreService.getAllPetStores();
    }

    @GetMapping("/{id}")
    public PetStore getPetStoreById(@PathVariable Long id) {
        return petStoreService.getPetStoreById(id);
    }

    @PostMapping
    public PetStore createPetStore(@RequestBody PetStore petStore) {
        return petStoreService.savePetStore(petStore);
    }

    @PutMapping("/{id}")
    public PetStore updatePetStore(@PathVariable Long id, @RequestBody PetStore petStore) {
        petStore.setId(id);
        return petStoreService.savePetStore(petStore);
    }

    @DeleteMapping("/{id}")
    public void deletePetStore(@PathVariable Long id) {
        petStoreService.deletePetStore(id);
    }
}
