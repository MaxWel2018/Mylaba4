package lesson6.task4.repository;

import lesson6.task4.domain.Student;

import java.util.List;

public interface StudentRepository extends Repository<Student> {
     List<Student> findByDepartmentName(String nameDepartment);

     List<Student> findByName(String name);

     List<Student> findByGroup(String name);

     List<Student> findByDepartmentId(Long id);

     List<Student> filterByDepartment(String nameDepartment);

     List<Student> filterByAfterGivenYear(int year);

     List<Student> filterByGroup(String nameGroup);
}
