package app.university.services;

import app.university.entities.Department;
import app.university.entities.Lector;
import app.university.repositories.DepartmentRepository;
import app.university.repositories.LectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class UniversityService {
    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;

    public UniversityService(DepartmentRepository departmentRepository, LectorRepository lectorRepository) {
        this.departmentRepository = departmentRepository;
        this.lectorRepository = lectorRepository;
    }

    public String getDepartmentHeadName(String name) {
        Department department = departmentRepository
            .findByNameIgnoreCase(name)
            .orElseThrow();

        return department.getHead().getName();
    }

    public Double getAverageSalary(String name) {
        return departmentRepository
            .getAverageSalary(name)
            .orElseThrow();
    }

    public Long getEmployeeCount(String name) {
        return departmentRepository
            .countEmployeesByName(name)
            .orElseThrow();
    }

    public String getGlobalSearchResults(String substring) {
        List<Department> departmentList = departmentRepository.findAllByNameContainingIgnoreCase(substring);
        List<Lector> lectorList = lectorRepository.findAllByNameContainingIgnoreCase(substring);
        List<String> joined = Stream
            .concat(
                departmentList.stream().map(Department::getName),
                lectorList.stream().map(Lector::getName))
            .toList();

        return String.join(", ", joined);
    }
}
