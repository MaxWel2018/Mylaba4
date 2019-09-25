package lesson6.task4.repository;

import lesson6.task4.domain.Group;

public interface GroupRepository {
    Group save(Group student);

    //R
    Group findById(Long id);

    //U
    void update(Group student);

    //D
    Group deleteById(Long id);
}
