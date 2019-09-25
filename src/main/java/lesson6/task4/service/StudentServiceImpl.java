package lesson6.task4.service;

import lesson6.task4.domain.Student;
import lesson6.task4.repository.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List filterByDepartment(String nameFaculty) {
        return studentRepository.filterByDepartment(nameFaculty);
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
