package lesson6.task4.repository;

import lesson6.task4.domain.Student;

import java.util.List;
import java.util.Map;

//CRUD
//C - create
//R - read
//U - update
//D - delete
public interface StudentRepository {
    // C
    Student save(Student student);

    //R
    Student findById(Long id);

    //U
    void update(Student student);

    //D
    Student deleteById(Long id);

    public List filterByDepartment(String nameDepartment);

    List filterByGroup(String nameGroup);

    List filterByAfterGivenYear(int year);

    Map<String,List> filterByAllDepartmentAndAllCourse();





}
