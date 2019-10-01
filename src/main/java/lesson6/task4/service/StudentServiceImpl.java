package lesson6.task4.service;

import lesson6.task4.domain.Department;
import lesson6.task4.domain.Group;
import lesson6.task4.domain.Student;
import lesson6.task4.repository.DepartmentRepository;
import lesson6.task4.repository.GroupRepository;
import lesson6.task4.repository.StudentRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lesson6.task4.service.ValidateService.notNull;

@Service
public class StudentServiceImpl implements StudentService, FilterService{
    private static final Logger LOGGER = Logger.getLogger(StudentServiceImpl.class);
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepo, GroupRepository groupRepo, DepartmentRepository departmentRepo) {

        this.studentRepository = studentRepo;
        this.groupRepository = groupRepo;
        this.departmentRepository = departmentRepo;
    }


    @Override
    public boolean checkWithRegExp(String testParam, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(testParam);
        return m.matches();
    }

    @Override
    public List<Student> filterByGroup(String nameGroup) {
        notNull(nameGroup);
        return studentRepository.filterByGroup(nameGroup);
    }

    @Override
    public List<Student> filterByDepartment(String nameDepartment) {
        notNull(nameDepartment);
        return studentRepository.filterByGroup(nameDepartment);
    }

    @Override
    public List<Student> filterByAfterGivenYear(int year) {
        return studentRepository.filterByAfterGivenYear(year);
    }

    @Override
    public Student register(Student student) {
        notNull(student);
        return studentRepository.save(student);
    }

    @Override
    public void updateData(Student student) {
        notNull(student);
        studentRepository.update(student);

    }

    @Override
    public Group findGroupById(Long id) {
        notNull(id);
        if (groupRepository.findById(id).isPresent()) {
            return groupRepository.findById(id).get();
        } else {
            throw new EntityNotFoundException("Group with id = " + id + " Not found ");
        }
    }

    @Override
    public Department findDepartmentById(Long id) {
        return departmentRepository.deleteById(id);
    }

    @Override
    public Department findDepartmentByGroupId(Long id) {
        Optional<Group> group = groupRepository.findById(id);
        if (group.isPresent()) {
            Long idDepartment = group.get().getIdDepartment();
            if (departmentRepository.findById(idDepartment).isPresent()) {
                return departmentRepository.findById(idDepartment).get();
            }
            throw new EntityNotFoundException("Department not found ");

        }
        throw new EntityNotFoundException("Department not found ");

    }


}
