package fr.epsi.b3devc1.multicouches.repository;

import fr.epsi.b3devc1.multicouches.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
