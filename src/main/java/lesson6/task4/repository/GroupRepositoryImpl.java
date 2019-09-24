package lesson6.task4.repository;

import lesson6.task4.domain.Group;

import javax.persistence.EntityNotFoundException;
import java.util.*;

public class GroupRepositoryImpl implements GroupRepository {
    private static GroupRepositoryImpl instance;
    private Map<Long, List<Group>> idToGroup = new HashMap<>();

    private void updateIndices(List<Group> groups) {
        for (Group group : groups) {
            idToGroup.computeIfAbsent(group.getIdDepartment(), id -> new ArrayList<>()).add(group);
        }
    }

    private void updateIndices(Group group) {
        idToGroup.computeIfAbsent(group.getIdDepartment(), id -> new ArrayList<>()).add(group);
    }

    private void updateIndices(Group... groups) {
        for (Group group : groups) {
            idToGroup.computeIfAbsent(group.getIdDepartment(), id -> new ArrayList<>()).add(group);
        }
    }

    {
        Group groupG1 = new Group(1L, "Group_G1");
        Group groupG2 = new Group(1L, "Group_G2");
        Group groupG3 = new Group(1L, "Group_G3");
        Group groupS1 = new Group(1L, "Group_S1");
        Group groupS2 = new Group(1L, "Group_S2");
        Group groupS3 = new Group(1L, "Group_S3");
        updateIndices(groupS1, groupS2, groupS3, groupG1, groupG2, groupG3);
    }

    public Map<Long, List<Group>> getIdToGroup() {
        return idToGroup;
    }

    @Override
    public Group save(Group group) {
        updateIndices(group);
        return group;

    }

    @Override
    public Group findById(Long id) {
        if (id >= 0) {
            for (List<Group> value : idToGroup.values()) {
                for (Group group : value) {
                    if (group.getId().equals(id)) {
                        return group;
                    }
                }
            }
        }
        throw new EntityNotFoundException();
    }

    @Override
    public void update(Group group) {
        updateIndices(group);
    }

    @Override
    public Group deleteById(Long id) {
        if (id >= 0) {
            for (List<Group> value : idToGroup.values()) {
                for (Group group : value) {
                    if (group.getId().equals(id)) {
                        value.remove(group);
                    }
                }
            }
        }
        throw new EntityNotFoundException();
    }

    private GroupRepositoryImpl() {
    }

    public static GroupRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new GroupRepositoryImpl();
        }
        return instance;
    }
}
