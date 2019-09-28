package lesson6.task4.repository;

import lesson6.task4.domain.Department;

import java.util.List;

public interface DepartmentRepository extends Repository<Department> {
    public List<Department> findByName(String name);
}
