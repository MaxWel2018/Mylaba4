package lesson6.task4.repository;

import lesson6.task4.domain.Department;
import lesson6.task4.domain.Group;
import lesson6.task4.domain.Student;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentRepositoryImpl implements StudentRepository {
    private static StudentRepositoryImpl instance;
    private Map<Long, Student> idToStudents = new HashMap<>();

    {

        save(
                Student.builder()
                        .withGroup(new Group(1L, "Group_G2"))
                        .withDepartment(new Department(1L, "Gryffindor"))
                        .withName("Max")
                        .build()
        );
        save(
                Student.builder()
                        .withGroup(new Group(1L, "Group_G3"))
                        .withDepartment(new Department(1L, "Gryffindor"))
                        .withName("Den").build()
        );
        save(
                Student.builder()
                        .withGroup(new Group(2L, "Group_S2"))
                        .withDepartment(new Department(1L, "Slytherin"))
                        .withName("Alex")
                        .build()
        );
    }

    private StudentRepositoryImpl() {
    }

    public static StudentRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new StudentRepositoryImpl();
            return instance;
        } else return instance;
    }

    @Override
    public List filterByGroup(String nameGroup) {
        if (idToStudents != null && nameGroup != null) {
            List<Student> filteredStudents = idToStudents.values().stream()
                    .filter(x -> x.getGroup().getName().equals(nameGroup))
                    .collect(Collectors.toList());
            if (filteredStudents.size() > 0)
                return filteredStudents;
            else throw new EntityNotFoundException();
        } else throw new IllegalArgumentException();

    }

    @Override
    public List filterByAfterGivenYear(int year) {
        if (idToStudents != null && year >= 0) {
            List filteredStudents = idToStudents.values().stream()
                    .filter(x -> x.getBirthday().getYear() >= year)
                    .collect(Collectors.toList());
            if (filteredStudents.size() > 0)
                return filteredStudents;
            else throw new EntityNotFoundException();
        } else throw new IllegalArgumentException();
    }

    @Override
    public Map<String, List> filterByAllDepartmentAndAllCourse() {
        DepartmentRepositoryImpl departmentRepository = DepartmentRepositoryImpl.getInstance();
        Map<Long, Department> idToDepartment = departmentRepository.getIdToDepartment();
        GroupRepositoryImpl groupRepository = GroupRepositoryImpl.getInstance();
        Map<Long, List<Group>> idToGroup = groupRepository.getIdToGroup();
        Map<String, List> filteredStudents = new HashMap<>();

        if (idToStudents != null) {
            for (Department value : idToDepartment.values()) {
                List list = filterByDepartment(value.getName());
                filteredStudents.put("department", list);
            }
            if (idToStudents != null) {
                for (List<Group> value : idToGroup.values()) {
                    for (Group group : value) {
                        List list = filterByGroup(group.getName());
                        filteredStudents.put("group", list);
                    }
                }
            }
            if (filteredStudents.size() > 0)
                return filteredStudents;
            else throw new EntityNotFoundException();
        } else throw new IllegalArgumentException();
    }

    public List filterByDepartment(String nameDepartment) {
        if (idToStudents != null && nameDepartment != null) {
            List filteredStudents = idToStudents.values().stream()
                    .filter(student -> (student.getDepartment().getName().equals(nameDepartment)))
                    .collect(Collectors.toList());
            if (filteredStudents.size() > 0)
                return filteredStudents;
            else throw new EntityNotFoundException();
        } else throw new IllegalArgumentException();
    }

    @Override
    public Student save(Student student) {
        //
        return idToStudents.put(student.getId(), student);
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
