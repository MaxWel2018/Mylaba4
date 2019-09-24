package lesson6.task4.service;

import lesson6.task4.domain.Student;
import lesson6.task4.repository.StudentRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

//    private StudentRepository studentRepository=new StudentRepository() {
//        @Override
//        public Student save(Student student) {
//            return null;
//        }
//
//        @Override
//        public Student findById(Long id) {
//            return null;
//        }
//
//        @Override
//        public void update(Student student) {
//
//        }
//
//        @Override
//        public Student deleteById(Long id) {
//            return null;
//        }
//    };
//    private StudentServiceImpl studentService = new StudentServiceImpl();

//    private StudentRepository studentRepository = Mockito.mock(StudentRepository.class);
//    private StudentServiceImpl studentService = new StudentServiceImpl(studentRepository);

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @After
    public void resetMock() {
        reset(studentRepository);
    }

    @Test
    public void test1() {
        Student student = Student.builder().withId(1L).build();
        Student student1 = studentService.register(student);
        System.out.println(student1);
    }

    @Test
    public void test2() {
        Student student = Student.builder().withId(1L).build();
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        Student student1 = studentService.register(student);
        assertNotNull(student1);

    }

}