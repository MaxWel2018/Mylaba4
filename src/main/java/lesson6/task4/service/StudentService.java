package lesson6.task4.service;

import lesson6.task4.domain.Department;
import lesson6.task4.domain.Group;
import lesson6.task4.domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    boolean checkWithRegExp(String testParam, String regex);

    Student register(Student student);

    void updateData(Student student);

    Group findGroupById(Long id);
    Department findDepartmentById(Long id);

    Department findDepartmentByGroupId(Long id);
}
