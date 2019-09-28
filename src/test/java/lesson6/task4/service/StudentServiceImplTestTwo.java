package lesson6.task4.service;

import lesson6.task4.domain.Department;
import lesson6.task4.domain.Group;
import lesson6.task4.domain.Student;
import lesson6.task4.repository.StudentRepositoryImpl;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTestTwo {
//    @Mock
//    private StudentRepositoryImpl repositoryMock;
//    @InjectMocks
//    private StudentServiceImpl studentService;
//
//    @After
//    public void resetMock() {
//        reset(repositoryMock);
//    }
//
//    @Test
//    public void shouldReturnStudentWhenSaving() {
//        Student student = Student.builder().withId(1L).build();
//        when(repositoryMock.save(any(Student.class))).thenReturn(student);
//        Student student1 = studentService.register(student);
//        assertNotNull(student1);
//    }
//    @Test
//    public void shouldReturnListStudentWhenFilteringByGroup() {
//        Student student = Student.builder().withName("Max").withId(1L).withGroup(new Group(1L, nameDepartment, "GroupG_2")).build();
//        when(repositoryMock.findByGroup(any(String.class))).thenReturn(anyList());
//        List<Student> students = studentService.filterByGroup("Group_G2");
//        assertNotNull(students);
//    }
//    @Test
//    public void shouldReturnListStudentWhenFilteringByDepartment() {
//        Student student = Student.builder().withName("Max").withId(1L).withDepartment(new Department(1L,"Gryffindor")).withGroup(new Group(1L, nameDepartment, "GroupG_2")).build();
//        when(repositoryMock.findByDepartmentName(any(String.class))).thenReturn(anyList());
//        List<Student> students = studentService.filterByDepartment("Gryffindor");
//        assertNotNull(students);
//    }




}