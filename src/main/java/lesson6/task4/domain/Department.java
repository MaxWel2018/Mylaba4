package lesson6.task4.domain;

public class Department {
    private final Long id;
    private final String name;

    public Department(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

}
