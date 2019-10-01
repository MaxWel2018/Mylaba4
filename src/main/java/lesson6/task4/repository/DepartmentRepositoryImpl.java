package lesson6.task4.repository;

import lesson6.task4.domain.Department;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {
    private static final AtomicLong SEQUENCE = new AtomicLong(1);
    private static Map<String, List<Department>> byName = Collections.emptyMap();
    private static Map<Long, Department> idToDepartment = new HashMap<>();

  static{
        Department gryffindor = new Department(1L, "Gryffindor");
        Department slytherin = new Department(2L, "Slytherin");
        idToDepartment.put(gryffindor.getId(), gryffindor);
        idToDepartment.put(slytherin.getId(), slytherin);
    }


    @Override
    public  Map<Long, Department> getIdToDepartment() {
        return idToDepartment;
    }

    @Override
    public Department save(Department department) {
        Long id = department.getId();
        if (id == null) {
            id = SEQUENCE.getAndIncrement();
        }
        idToDepartment.put(id, department);
        updateIndices();
        return idToDepartment.get(id);
    }

    @Override
    public Optional<Department> findById(Long id) {
        return Optional.ofNullable(idToDepartment.get(id));
    }

    @Override
    public List<Department> findByName(String name) {
        return byName.getOrDefault(name, Collections.emptyList());
    }

    @Override
    public void update(Department department) {
        save(department);
    }

    @Override
    public Department deleteById(Long id) {
        Department department = idToDepartment.remove(id);
        updateIndices();
        return department;
    }

    private void updateIndices() {
        byName = idToDepartment.values().stream().collect(Collectors.groupingBy(Department::getName));
    }

}
