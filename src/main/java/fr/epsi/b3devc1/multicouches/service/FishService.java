package fr.epsi.b3devc1.multicouches.service;

import fr.epsi.b3devc1.multicouches.model.Fish;
import fr.epsi.b3devc1.multicouches.repository.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishService {

    @Autowired
    private FishRepository fishRepository;

    public List<Fish> getAllFish() {
        return fishRepository.findAll();
    }

    public Fish getFishById(Long id) {
        return fishRepository.findById(id).orElse(null);
    }

    public Fish saveFish(Fish fish) {
        return fishRepository.save(fish);
    }

    public void deleteFish(Long id) {
        fishRepository.deleteById(id);
    }
}
