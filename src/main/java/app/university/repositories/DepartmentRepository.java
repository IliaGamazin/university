package app.university.repositories;

import app.university.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByNameIgnoreCase(String name);

    List<Department> findAllByNameContainingIgnoreCase(String name);

    @Query("SELECT AVG(e.salary) FROM Department d JOIN d.employees e WHERE d.name = :name")
    Optional<Double> getAverageSalary(@Param("name") String name);

    @Query("SELECT COUNT(e) FROM Department d JOIN d.employees e WHERE d.name = :name")
    Optional<Long> countEmployeesByName(@Param("name") String name);
}
