package lesson6.task4.repository;

import java.util.Optional;

public interface Repository<T> {
    T save(T student);

    void update(T student);

    Optional<T> findById(Long id);

    T deleteById(Long id);

}

