package lesson6.task4.repository;

import lesson6.task4.domain.Group;

import java.util.List;
import java.util.Map;

public interface GroupRepository extends Repository<Group> {
    public Map<Long, Group> getIdToGroup();
    public List<Group> findByDepartmentId(Long id);

    public List<Group> findByName(String name);

}
