package fr.epsi.b3devc1.multicouches.repository;

import fr.epsi.b3devc1.multicouches.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByPetStoreId(Long petStoreId);
}
