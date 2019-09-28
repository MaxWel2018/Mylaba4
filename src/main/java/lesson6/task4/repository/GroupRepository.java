package lesson6.task4.repository;

import lesson6.task4.domain.Group;

import java.util.List;

public interface GroupRepository extends Repository<Group> {
    public List<Group> findByDepartmentId(Long id);

    public List<Group> findByName(String name);

}
