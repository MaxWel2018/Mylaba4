package lesson6.task4.repository;

import lesson6.task4.domain.Department;
import lesson6.task4.domain.Group;
import lesson6.task4.domain.Student;

import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class StudentRepositoryImpl implements Repository<Student> {
   public static final StudentRepositoryImpl STUDENT_REPOSITORY = new StudentRepositoryImpl();
    private static final Map<Long, Student> STUDENTS = new HashMap<>();
    private static final AtomicLong SEQUENCE = new AtomicLong(1);
    private static Map<Long, List<Student>> byDepartmentId = Collections.emptyMap(); // список отсортированых по факультету
    private static Map<String, List<Student>> byName = Collections.emptyMap(); // по группам

    private void updateIndices() {
        byDepartmentId = STUDENTS.values().stream().collect(Collectors.groupingBy(Student::getId));
        byName = STUDENTS.values().stream().collect(Collectors.groupingBy(Student::getName));
    }



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



    public List filterByGroup(String nameGroup) {
        Objects.requireNonNull(nameGroup);
        return GroupRepositoryImpl.GROUP_REPOSITORY.findByName(nameGroup);

    }

    public Optional<List> filterByAfterGivenYear(int year) {
        Objects.requireNonNull(year);
            List filteredStudents = STUDENTS.values().stream()
                    .filter(x -> x.getBirthday().getYear() >= year)
                    .collect(Collectors.toList());
                return Optional.of(filteredStudents);
    }

    public List filterByDepartment(String nameDepartment) {
        Objects.requireNonNull(nameDepartment);
        return DepartmentRepositoryImpl.DEPARTMENT_REPOSITORY.findByName(nameDepartment);
    }

    @Override
    public Student  save(Student student) {
        Objects.requireNonNull(student);
        Long id = student.getId();
        if (id == null) {
            id = SEQUENCE.getAndIncrement();
            student.setId(id);
        }
        STUDENTS.put(id, student);
        updateIndices();
        return STUDENTS.get(id);
    }

    @Override
    public Optional<Student> findById(Long id) {
        Objects.requireNonNull(id);
        return Optional.ofNullable(STUDENTS.get(id));
    }

    @Override
    public List<Student> findByDepartmentId(Long id) {
        Objects.requireNonNull(id);
        return byDepartmentId.getOrDefault(id, Collections.emptyList());
    }

    @Override
    public List<Student> findByName(String name) {
        Objects.requireNonNull(name);
        return byName.getOrDefault(name, Collections.emptyList());
    }

    @Override
    public void update(Student student) {
        save(student);
    }

    @Override
    public Student deleteById(Long id) {
        Objects.requireNonNull(id);
        Student student = STUDENTS.remove(id);
        updateIndices();
        return student;
    }
}
