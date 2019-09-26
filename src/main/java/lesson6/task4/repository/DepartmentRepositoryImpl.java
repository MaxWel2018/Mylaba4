package lesson6.task4.repository;

import lesson6.task4.domain.Department;
import lesson6.task4.domain.Group;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class DepartmentRepositoryImpl implements Repository<Department> {
    private static final Map<Long, Department> DEPARMENTS = new HashMap<>();
    public final static DepartmentRepositoryImpl DEPARTMENT_REPOSITORY = new DepartmentRepositoryImpl();
    private static Map<Long, List<Department>> byDepartmentId = Collections.emptyMap(); // список отсортированых по факультету
    private static Map<String, List<Department>> byName = Collections.emptyMap(); // по группам
    private static final AtomicLong SEQUENCE = new AtomicLong(1);



    {
        Department gryffindor = new Department(1L, "Gryffindor");
        Department slytherin = new Department(2L, "Slytherin");
        DEPARMENTS.put(gryffindor.getId(), gryffindor);
        DEPARMENTS.put(slytherin.getId(), slytherin);
    }

    @Override
    public Department save(Department department) {
        Objects.requireNonNull(department);
        Long id = department.getId();
        if (id == null) {
            id = SEQUENCE.getAndIncrement();
        }
        DEPARMENTS.put(id, department);
        updateIndices();
        return DEPARMENTS.get(id);
    }
    @Override
    public Optional<Department> findById(Long id) {
        Objects.requireNonNull(id);
        return Optional.ofNullable(DEPARMENTS.get(id));
    }

    private DepartmentRepositoryImpl() {

    }
    @Override
    public  List<Department> findByDepartmentId(Long id) {
        Objects.requireNonNull(id);
        return byDepartmentId.getOrDefault(id, Collections.emptyList());
    }
    @Override
    public List<Department> findByName(String name) {
        Objects.requireNonNull(name);
        return byName.getOrDefault(name, Collections.emptyList());
    }

    @Override
    public void update(Department department) {
        save(department);    }

    @Override
    public Department deleteById(Long id) {
        Objects.requireNonNull(id);
        Department department = DEPARMENTS.remove(id);
        updateIndices();
        return department;
    }
    private void updateIndices() {
        byDepartmentId = DEPARMENTS.values().stream().collect(Collectors.groupingBy(Department::getId));
        byName = DEPARMENTS.values().stream().collect(Collectors.groupingBy(Department::getName));
    }
    public static Map<Long, Department> getIdToDepartment() {
        return DEPARMENTS;
    }
}
