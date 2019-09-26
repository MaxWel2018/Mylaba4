package lesson6.task4.service;

import lesson6.task4.domain.Student;
import lesson6.task4.repository.StudentRepositoryImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService,FilterService {
    private final StudentRepositoryImpl studentRepository;

    public StudentServiceImpl(StudentRepositoryImpl studentRepository) {
        this.studentRepository = studentRepository;
    }

    public  List filterByGroup(String nameGroup) {
        return StudentRepositoryImpl.STUDENT_REPOSITORY.filterByGroup(nameGroup);
    }

    public List filterByDepartment(String nameDepartment) {
        return StudentRepositoryImpl.STUDENT_REPOSITORY.filterByGroup(nameDepartment);
    }

    public List filterByAfterGivenYear(int year) {
        return StudentRepositoryImpl.STUDENT_REPOSITORY.filterByAfterGivenYear(year);
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
