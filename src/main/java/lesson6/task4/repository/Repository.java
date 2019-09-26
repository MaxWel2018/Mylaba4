package lesson6.task4.repository;

import lesson6.task4.domain.Group;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    T save(T student);

    void update(T student);

    Optional<T> findById(Long id);


    List<T> findByDepartmentId(Long id);

    List<T> findByName(String name);

    T deleteById(Long id);

}

