package lesson6.task4.repository;

import lesson6.task4.domain.Department;

import java.util.HashMap;
import java.util.Map;

public class DepartmentRepositoryImpl implements DepartmentRepository {
    private Map<Long, Department> idToDepartment = new HashMap<>();
    private static DepartmentRepositoryImpl instance;

    {
        Department gryffindor = new Department(1L, "Gryffindor");
        Department slytherin = new Department(2L, "Slytherin");
        idToDepartment.put(gryffindor.getId(), gryffindor);
        idToDepartment.put(slytherin.getId(), slytherin);
    }

    @Override
    public Department save(Department department) {
        return idToDepartment.put(department.getId(), department);
    }

    @Override
    public Department findById(Long id) {
        return idToDepartment.get(id);
    }

    @Override
    public void update(Department department) {
        idToDepartment.replace(department.getId(), department);
    }

    @Override
    public Department deleteById(Long id) {
        return idToDepartment.remove(id);
    }

    private DepartmentRepositoryImpl() {
    }

    public static DepartmentRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new DepartmentRepositoryImpl();
        }
        return instance;
    }

    public Map<Long, Department> getIdToDepartment() {
        return idToDepartment;
    }
}
