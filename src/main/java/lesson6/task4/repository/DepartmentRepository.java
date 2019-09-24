package lesson6.task4.repository;

import lesson6.task4.domain.Department;

public interface DepartmentRepository {
    Department save(Department student);

    //R
    Department findById(Long id);

    //U
    void update(Department student);

    //D
    Department deleteById(Long id);
}
