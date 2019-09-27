package lesson6.task4.repository;

import lesson6.task4.domain.Department;
import lesson6.task4.domain.Group;
import lesson6.task4.domain.Student;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class StudentRepositoryImpl implements Repository<Student> {
    private static final Map<Long, Student> STUDENTS = new HashMap<>();
    private static final AtomicLong SEQUENCE = new AtomicLong(1);
    private static Map<String, List<Student>> byDepartmentName = Collections.emptyMap();
    private static Map<Long, List<Student>> byDepartmentId = Collections.emptyMap();
    private static Map<String, List<Student>> byName = Collections.emptyMap();
    private static Map<String, List<Student>> byGroup   = Collections.emptyMap();
    public static final StudentRepositoryImpl STUDENT_REPOSITORY = new StudentRepositoryImpl();

    public  StudentRepositoryImpl getStudentRepository() {
        return STUDENT_REPOSITORY;
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


    public List<Student> filterByGroup(String nameGroup) {
        Objects.requireNonNull(nameGroup);
        return StudentRepositoryImpl.STUDENT_REPOSITORY.findByGroup(nameGroup);

    }

    public List<Student> filterByAfterGivenYear(int year) {
        return STUDENTS.values().stream()
                .filter(x -> x.getBirthday().getYear() >= year)
                .collect(Collectors.toList());
    }

    public List<Student> filterByDepartment(String nameDepartment) {
        Objects.requireNonNull(nameDepartment);
        return StudentRepositoryImpl.STUDENT_REPOSITORY.findByDepartmentName(nameDepartment);
    }

    @Override
    public Student save(Student student) {
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

    public List<Student> findByGroup(String name) {
        Objects.requireNonNull(name);
        return byGroup.getOrDefault(name, Collections.emptyList());
    }

    public List<Student> findByDepartmentName(String nameDepartment) {
        Objects.requireNonNull(nameDepartment);
        return byDepartmentName.getOrDefault(nameDepartment, Collections.emptyList());
    }

    @Override
    public void update(Student student) {
        save(student);
    }

    private void updateIndices() {
        byDepartmentId = STUDENTS.values().stream().collect(Collectors.groupingBy(Student::getId));
        byName = STUDENTS.values().stream().collect(Collectors.groupingBy(Student::getName));
        byGroup = STUDENTS.values().stream().collect(Collectors.groupingBy((Student student) -> student.getGroup().getName()));
        byDepartmentName = STUDENTS.values().stream().collect(Collectors.groupingBy(student1 -> student1.getDepartment().getName()));
    }

    @Override
    public Student deleteById(Long id) {
        Objects.requireNonNull(id);
        Student student = STUDENTS.remove(id);
        updateIndices();
        return student;
    }
}
