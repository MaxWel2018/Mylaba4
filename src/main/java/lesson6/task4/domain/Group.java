package lesson6.task4.domain;

public class Group {
    private final Long id;
    private static Long idStatic = 0L;
    private final Long idDepartment;
    private final String name;

    public Group(Long idDepartment, String name) {
        this.idDepartment = idDepartment;
        this.name = name;
        this.id = ++idStatic;
    }


    public Long getId() {
        return id;
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
