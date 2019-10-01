package lesson6.task4.repository;

import lesson6.task4.domain.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentRepository extends Repository<Department> {
    public Map<Long, Department> getIdToDepartment();
    public List<Department> findByName(String name);
}
