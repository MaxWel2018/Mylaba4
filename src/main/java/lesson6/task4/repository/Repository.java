package lesson6.task4.repository;

import lesson6.task4.domain.Group;

public interface Repository<T> {
    T save(T student);

    //R
    T findById(Long id);

    //U
    void update(T student);

    //D
    T deleteById(Long id);
}

