package fr.epsi.b3devc1.multicouches.repository;

import fr.epsi.b3devc1.multicouches.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
}
