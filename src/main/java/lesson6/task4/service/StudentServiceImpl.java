package lesson6.task4.service;

import lesson6.task4.domain.Department;
import lesson6.task4.domain.Group;
import lesson6.task4.domain.Student;
import lesson6.task4.repository.DepartmentRepository;
import lesson6.task4.repository.GroupRepository;
import lesson6.task4.repository.StudentRepository;
import org.apache.log4j.Logger;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lesson6.task4.utility.RegexTemplate.*;

public class StudentServiceImpl implements StudentService, FilterService, ValidateService {
    private static final Logger LOGGER = Logger.getLogger(StudentServiceImpl.class);
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final DepartmentRepository departmentRepository;

    public StudentServiceImpl(StudentRepository studentRepo, GroupRepository groupRepo, DepartmentRepository departmentRepo) {
        Objects.requireNonNull(studentRepo);
        Objects.requireNonNull(groupRepo);
        Objects.requireNonNull(groupRepo);
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

    @Override
    public Group findGroupById(Long id) {
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


    @Override
    public boolean userValidate(Map<String, String[]> map) {
        try {
            for (Map.Entry<String, String[]> o : map.entrySet()) {

                if (o.getKey().equals("name") || o.getKey().equals("secondName") || o.getKey().equals("nameStreet")) {
                    for (String s : o.getValue()) {
                        if (!checkWithRegExp(s, REGEX_FOR_NAME)) {
                            throw new IllegalArgumentException("Dont correct input");
                        }
                    }
                }
                if (o.getKey().equals("numberApartment")) {
                    for (String s : o.getValue()) {
                        if (!checkWithRegExp(s, REGEX_FOR_NUMBER)) {
                            throw new IllegalArgumentException("Dont correct input");
                        }
                    }
                }
                if (o.getKey().equals("phone")) {
                    for (String s : o.getValue()) {
                        if (!checkWithRegExp(s, REGEX_FOR_PHONE_NUMBER)) {
                            throw new IllegalArgumentException("Dont correct input");
                        }
                    }
                }
                if (o.getKey().equals("birthday")) {
                    for (String s : o.getValue()) {
                        if (!checkWithRegExp(s, REGEX_FOR_BIRTHDAY)) {
                            throw new IllegalArgumentException("Dont correct input");
                        }
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            LOGGER.error(e.getMessage());
            throw e;  // TODO крашить програму или пусть работает ?
        }
        return true;
    }
}
