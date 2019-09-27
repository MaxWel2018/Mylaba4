package lesson6.task4.service;

import lesson6.task4.domain.Student;

import java.util.List;

public interface FilterService {
    List<Student> filterByDepartment(String nameDepartment);

    List<Student> filterByAfterGivenYear(int year);

    List<Student> filterByGroup(String nameGroup);


}
