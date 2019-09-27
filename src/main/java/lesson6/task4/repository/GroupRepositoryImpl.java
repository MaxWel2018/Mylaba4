package lesson6.task4.repository;

import lesson6.task4.domain.Group;
import lesson6.task4.domain.Student;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class GroupRepositoryImpl implements Repository<Group> {
    private static final AtomicLong SEQUENCE = new AtomicLong(1);
    private static final Map<Long, Group> GROUPS = new HashMap<>();
    private static Map<Long, List<Group>> byDepartmentId = Collections.emptyMap();
    private static Map<String, List<Group>> byName = Collections.emptyMap();
    public static final GroupRepositoryImpl GROUP_REPOSITORY = new GroupRepositoryImpl();

    {
        save(new Group(1L, "Group_G1"));
        save(new Group(1L, "Group_G2"));
        save(new Group(1L, "Group_G3"));
        save(new Group(2L, "Group_S1"));
        save(new Group(2L, "Group_S2"));
        save(new Group(2L, "Group_S3"));
        updateIndices();
    }

    private GroupRepositoryImpl() {
    }

    public static Map<Long, List<Group>> getByDepartmentId() {
        return byDepartmentId;
    }

    public static Map<String, List<Group>> getByName() {
        return byName;
    }

    public static GroupRepositoryImpl getGroupRepository() {
        return GROUP_REPOSITORY;

    }

    public static Map<Long, Group> getGROUPS() {
        return GROUPS;
    }

    @Override
    public Group save(Group group) {
        Objects.requireNonNull(group);
        Long id = group.getId();
        if (id == null) {
            id = SEQUENCE.getAndIncrement();
            group.setId(id);
        }
        GROUPS.put(id, group);
        updateIndices();
        return GROUPS.get(id);
    }


    @Override
    public void update(Group group) {
        save(group);
    }

    @Override
    public  Optional<Group> findById(Long id) {
        Objects.requireNonNull(id);
        return Optional.ofNullable(GROUPS.get(id));
    }

    @Override
    public List<Group> findByDepartmentId(Long id) {
        Objects.requireNonNull(id);
        return byDepartmentId.getOrDefault(id, Collections.emptyList());
    }

    @Override
    public List<Group> findByName(String name) {
        Objects.requireNonNull(name);
        return byName.getOrDefault(name, Collections.emptyList());
    }

    @Override
    public Group deleteById(Long id) {
        Objects.requireNonNull(id);
        Group group = GROUPS.remove(id);
        updateIndices();
        return group;
    }

    private void updateIndices() {
        byDepartmentId = GROUPS.values().stream().collect(Collectors.groupingBy(Group::getId));
        byName = GROUPS.values().stream().collect(Collectors.groupingBy(Group::getName));
    }
}
