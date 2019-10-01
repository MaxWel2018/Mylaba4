package lesson6.task4.repository;

import lesson6.task4.domain.Department;
import lesson6.task4.domain.Group;
import lesson6.task4.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private static final AtomicLong SEQUENCE = new AtomicLong(1);
    private static Map<String, List<Student>> byDepartmentName = Collections.emptyMap();
    private static Map<Long, List<Student>> byDepartmentId = Collections.emptyMap();
    private static Map<String, List<Student>> byName = Collections.emptyMap();
    private static Map<String, List<Student>> byGroup = Collections.emptyMap();
    private static Map<Long, Student> idToStudents = new HashMap<>();


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

    @Override
    public List<Student> filterByGroup(String nameGroup) {
        return findByGroup(nameGroup);

    }

    @Override
    public List<Student> filterByAfterGivenYear(int year) {
        return idToStudents.values().stream()
                .filter(x -> x.getBirthday().getYear() >= year)
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> filterByDepartment(String nameDepartment) {
        return findByDepartmentName(nameDepartment);
    }

    @Override
    public Student save(Student student) {
        Long id = student.getId();
        if (id == null) {
            id = SEQUENCE.getAndIncrement();
            student.setId(id);
        }
        idToStudents.put(id, student);
        updateIndices();
        return idToStudents.get(id);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(idToStudents.get(id));
    }

    @Override
    public List<Student> findByDepartmentId(Long id) {
        return byDepartmentId.getOrDefault(id, Collections.emptyList());
    }

    @Override
    public List<Student> findByName(String name) {
        return byName.getOrDefault(name, Collections.emptyList());
    }

    @Override
    public List<Student> findByGroup(String name) {
        return byGroup.getOrDefault(name, Collections.emptyList());
    }

    @Override
    public List<Student> findByDepartmentName(String nameDepartment) {
        return byDepartmentName.getOrDefault(nameDepartment, Collections.emptyList());
    }

    @Override
    public void update(Student student) {
        save(student);
    }

    private void updateIndices() {
        byDepartmentId = idToStudents.values().stream().collect(Collectors.groupingBy(Student::getId));
        byName = idToStudents.values().stream().collect(Collectors.groupingBy(Student::getName));
        byGroup = idToStudents.values().stream().collect(Collectors.groupingBy((Student student) -> student.getGroup().getName()));
        byDepartmentName = idToStudents.values().stream().collect(Collectors.groupingBy(student1 -> student1.getDepartment().getName()));
    }

    @Override
    public Student deleteById(Long id) {
        Student student = idToStudents.remove(id);
        updateIndices();
        return student;
    }
}
