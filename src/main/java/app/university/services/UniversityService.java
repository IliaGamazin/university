package app.university.services;

import app.university.entities.Department;
import app.university.entities.Lector;
import app.university.repositories.DepartmentRepository;
import app.university.repositories.LectorRepository;
import app.university.utils.Degree;
import app.university.utils.DegreeCount;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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

    public String getStatistics(String name) {
        List<DegreeCount> stats = departmentRepository.getDepartmentStatistics(name);

        Map<Degree, Long> countsMap = stats.stream()
            .collect(Collectors.toMap(DegreeCount::degree, DegreeCount::count));

        return Arrays.stream(Degree.values())
            .map(degree -> {
                String label = degree.toString().toLowerCase().replace("_", " ");
                Long count = countsMap.getOrDefault(degree, 0L);
                return label + "s - " + count;
            })
            .collect(Collectors.joining("\n"));
    }

    public Double getAverageSalary(String name) {
        return departmentRepository
            .getAverageSalary(name)
            .orElse(0.0);
    }

    public Long getEmployeeCount(String name) {
        return departmentRepository
            .countEmployeesByName(name)
            .orElse(0L);
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
