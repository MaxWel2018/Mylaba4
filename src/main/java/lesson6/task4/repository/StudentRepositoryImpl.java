package lesson6.task4.repository;

import lesson6.task4.domain.Student;

import java.util.HashMap;
import java.util.Map;
public class StudentRepositoryImpl implements StudentRepository {
    private static  StudentRepositoryImpl instance;
    private Map<Long, Student> idToStudents = new HashMap<>();

    public static StudentRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new StudentRepositoryImpl();
            return instance;
        }
        else return instance;
    }

    private StudentRepositoryImpl() {
    }

    @Override
    public Student save(Student student) {
        //
        return idToStudents.put(student.getId(),student);
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
