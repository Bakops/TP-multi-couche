package fr.epsi.b3devc1.multicouches.controller;

import fr.epsi.b3devc1.multicouches.model.Cat;
import fr.epsi.b3devc1.multicouches.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {

    @Autowired
    private CatService catService;

    @GetMapping
    public List<Cat> getAllCats() {
        return catService.getAllCats();
    }

    @GetMapping("/{id}")
    public Cat getCatById(@PathVariable Long id) {
        return catService.getCatById(id);
    }

    @PostMapping
    public Cat createCat(@RequestBody Cat cat) {
        return catService.saveCat(cat);
    }

    @PutMapping("/{id}")
    public Cat updateCat(@PathVariable Long id, @RequestBody Cat cat) {
        cat.setId(id);
        return catService.saveCat(cat);
    }

    @DeleteMapping("/{id}")
    public void deleteCat(@PathVariable Long id) {
        catService.deleteCat(id);
    }
}
