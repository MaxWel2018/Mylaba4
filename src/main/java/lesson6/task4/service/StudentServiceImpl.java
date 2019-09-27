package lesson6.task4.service;

import lesson6.task4.domain.Student;
import lesson6.task4.repository.Repository;
import lesson6.task4.repository.StudentRepositoryImpl;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentServiceImpl implements StudentService, FilterService {
    private final StudentRepositoryImpl studentRepository;

    public StudentServiceImpl(StudentRepositoryImpl studentRepository) {
        Objects.requireNonNull(studentRepository);
        this.studentRepository = studentRepository.getStudentRepository();
    }

    @Override
    public  boolean checkWithRegExp(String testParam, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(testParam);
        return m.matches();
    }
    //TODO глянуть регулярки и сделать валидацию

    @Override
    public List<Student> filterByGroup(String nameGroup) {
        Objects.requireNonNull(nameGroup);
        return studentRepository.filterByGroup(nameGroup);
    }

    @Override
    public List<Student> filterByDepartment(String nameDepartment) {
        Objects.requireNonNull(nameDepartment);
        return studentRepository.filterByGroup(nameDepartment);
    }

    @Override
    public List<Student> filterByAfterGivenYear(int year) {
        return studentRepository.filterByAfterGivenYear(year);
    }

    @Override
    public Student register(Student student) {
        Objects.requireNonNull(student);
        return studentRepository.save(student);
    }

    @Override
    public void updateData(Student student) {
        Objects.requireNonNull(student);
        studentRepository.update(student);

    }


}
