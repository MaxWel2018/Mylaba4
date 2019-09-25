package lesson6.task4.service;

import lesson6.task4.domain.Student;
import lesson6.task4.repository.StudentRepository;

import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    void filterByFacultyAndCourse() {

    }

    public List filterByDepartment(String nameDepartment) {
        return studentRepository.filterByDepartment(nameDepartment);
    }

    public Map<String, List> filterByAllDepartmentAndAllCourse() {
        return studentRepository.filterByAllDepartmentAndAllCourse();
    }

    public List filterByGroup(String nameGroup) {
        return studentRepository.filterByGroup(nameGroup);
    }

    public List filterByAfterGivenYear(int year) {
        return studentRepository.filterByAfterGivenYear(year);
    }

    @Override
    public Student register(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("");
        }
        return studentRepository.save(student);
    }

    @Override
    public void updateData(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("");
        }
        studentRepository.update(student);

    }


}
