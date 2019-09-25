package lesson6.task4;

import lesson6.task4.domain.Department;
import lesson6.task4.domain.Group;
import lesson6.task4.domain.Student;
import lesson6.task4.repository.StudentRepository;
import lesson6.task4.repository.StudentRepositoryImpl;
import lesson6.task4.service.StudentService;
import lesson6.task4.service.StudentServiceImpl;

import java.util.List;

public class ConsoleApplication {
    public static void main(String[] args) {

        StudentRepository studentRepository =  StudentRepositoryImpl.getInstance();
        StudentServiceImpl studentService = new StudentServiceImpl(studentRepository);

        studentRepository.save(
                Student.builder()
                        .withGroup(new Group(1L,"Group_G2"))
                        .withDepartment(new Department(1L,"Gryffindor"))
                        .withName("Max")
                        .build()
        );
        studentRepository.save(
                Student.builder()
                        .withGroup(new Group(1L,"Group_G3"))
                        .withDepartment(new Department(1L,"Gryffindor"))
                        .withName("Den").build()
        );
        studentRepository.save(
                Student.builder()
                        .withGroup(new Group(2L,"Group_S2"))
                        .withDepartment(new Department(1L,"Slytherin"))
                        .withName("Alex")
                        .build()
        );

        List list = studentService.filterByDepartment("Gryffindor");


    }
}
