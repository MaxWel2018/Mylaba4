package lesson6.task4.domain;

import java.util.Objects;

public class Group {
    private final Long idDepartment;
    private final String name;
    private Long id;


    public Group(Long idDepartment, String name) {
        Objects.requireNonNull(idDepartment);
        Objects.requireNonNull(name);
        this.idDepartment = idDepartment;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDepartment() {
        return idDepartment;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
