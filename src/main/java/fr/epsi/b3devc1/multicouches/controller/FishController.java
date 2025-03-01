package fr.epsi.b3devc1.multicouches.controller;

import fr.epsi.b3devc1.multicouches.model.Fish;
import fr.epsi.b3devc1.multicouches.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fish")
public class FishController {

    @Autowired
    private FishService fishService;

    @GetMapping
    public List<Fish> getAllFish() {
        return fishService.getAllFish();
    }

    @GetMapping("/{id}")
    public Fish getFishById(@PathVariable Long id) {
        return fishService.getFishById(id);
    }

    @PostMapping
    public Fish createFish(@RequestBody Fish fish) {
        return fishService.saveFish(fish);
    }

    @PutMapping("/{id}")
    public Fish updateFish(@PathVariable Long id, @RequestBody Fish fish) {
        fish.setId(id);
        return fishService.saveFish(fish);
    }

    @DeleteMapping("/{id}")
    public void deleteFish(@PathVariable Long id) {
        fishService.deleteFish(id);
    }
}
