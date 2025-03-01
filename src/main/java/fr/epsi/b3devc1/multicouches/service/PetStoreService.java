package fr.epsi.b3devc1.multicouches.service;
import fr.epsi.b3devc1.multicouches.model.PetStore;
import fr.epsi.b3devc1.multicouches.repository.PetStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetStoreService {

    @Autowired
    private PetStoreRepository petStoreRepository;

    public List<PetStore> getAllPetStores() {
        return petStoreRepository.findAll();
    }

    public PetStore getPetStoreById(Long id) {
        return petStoreRepository.findById(id).orElse(null);
    }

    public PetStore savePetStore(PetStore petStore) {
        return petStoreRepository.save(petStore);
    }

    public void deletePetStore(Long id) {
        petStoreRepository.deleteById(id);
    }
}
