package app.university.repositories;

import app.university.entities.Lector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    List<Lector> findAllByNameContainingIgnoreCase(String name);
}
