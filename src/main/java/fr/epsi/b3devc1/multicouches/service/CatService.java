package fr.epsi.b3devc1.multicouches.service;

import fr.epsi.b3devc1.multicouches.model.Cat;
import fr.epsi.b3devc1.multicouches.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    @Autowired
    private CatRepository catRepository;

    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    public Cat getCatById(Long id) {
        return catRepository.findById(id).orElse(null);
    }

    public Cat saveCat(Cat cat) {
        return catRepository.save(cat);
    }

    public void deleteCat(Long id) {
        catRepository.deleteById(id);
    }
}
