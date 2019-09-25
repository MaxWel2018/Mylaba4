package lesson6.task4.repository;

import lesson6.task4.domain.Department;
import lesson6.task4.domain.Group;
import lesson6.task4.domain.Student;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentRepositoryImpl implements StudentRepository {
    private static StudentRepositoryImpl instance;
    private Map<Long, Student> idToStudents = new HashMap<>();


    {

        save(
                Student.builder()
                        .withGroup(new Group(1L, "Group_G2"))
                        .withDepartment(new Department(1L, "Gryffindor"))
                        .withName("Max")
                        .build()
        );
        save(
                Student.builder()
                        .withGroup(new Group(1L, "Group_G3"))
                        .withDepartment(new Department(1L, "Gryffindor"))
                        .withName("Den").build()
        );
        save(
                Student.builder()
                        .withGroup(new Group(2L, "Group_S2"))
                        .withDepartment(new Department(1L, "Slytherin"))
                        .withName("Alex")
                        .build()
        );
    }

    private StudentRepositoryImpl() {
    }

    public static StudentRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new StudentRepositoryImpl();
            return instance;
        } else return instance;
    }

    List filterByAfterGivenYear(int year) {
        if (idToStudents != null && year >= 0) {
            List students = idToStudents.values().stream()
                    .filter(x -> x.getBirthday().getYear() >= year)
                    .collect(Collectors.toList());
            if (students.size() > 0)
                return students;
            else throw new EntityNotFoundException();
        } else throw new IllegalArgumentException();
    }

    public List filterByDepartment(String nameFaculty) {
        if (idToStudents != null && nameFaculty != null) {
            List students = idToStudents.values().stream()
                    .filter(student -> (student.getDepartment().getName().equals(nameFaculty)))
                    .collect(Collectors.toList());
            if (students.size() > 0)
                return students;
            else throw new EntityNotFoundException();
        } else throw new IllegalArgumentException();
    }

    @Override
    public Student save(Student student) {
        //
        return idToStudents.put(student.getId(), student);
    }

    @Override
    public Student findById(Long id) {
        return idToStudents.get(id);
    }

    @Override
    public void update(Student student) {

        this.idToStudents.replace(student.getId(), student);
//
    }

    @Override
    public Student deleteById(Long id) {
        return idToStudents.remove(id);
    }
}
