package lesson6.task4.service;

import lesson6.task4.domain.Student;

public interface StudentService {

    boolean checkWithRegExp(String testParam, String regex);

    Student register(Student student);

    void updateData(Student student);


}
