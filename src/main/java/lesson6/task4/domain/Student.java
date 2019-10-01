package lesson6.task4.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Student {
    private  Long id;
    private final String name;
    private final String surname;
    private final LocalDate birthday;
    private final Address address;
    private final String phoneNumber;
    private final Group group;
    private final Department department;



    private Student(Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.birthday = builder.birthday;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.group = builder.group;
        this.department = builder.department;
    }

    public static Builder builder() {

        return new Builder();
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public Long getNameDepartment() {

        return group.getIdDepartment();

    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Address getAddress() {
        return address;
    }

    public Department getDepartment() {
        return department;
    }

    public Group getGroup() {
        return group;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(birthday, student.birthday) &&
                Objects.equals(address, student.address) &&
                Objects.equals(phoneNumber, student.phoneNumber) &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, birthday, address,  phoneNumber, group);
    }

    public static class Builder {
        private static volatile Builder mInstance;
        public Department department;
        private Long id;
        private String name;
        private String surname;
        private LocalDate birthday;
        private Address address;
        private String phoneNumber;
        private Group group;


        private Builder() {
        }

        public static Builder getInstance() {
            if (mInstance == null) {
                synchronized (Builder.class) {
                    if (mInstance == null) {
                        mInstance = new Builder();
                    }
                }
            }
            return mInstance;
        }

        public Student build() {
            return new Student(this);
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }
        public Builder withGroup(Group group) {
            this.group = group;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder withBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder withDepartment(Department department) {
            this.department = department;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            if (phoneNumber!=null) {
                this.phoneNumber = phoneNumber;
            }else     this.phoneNumber = "";
            return this;
        }


    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                "," + address +
                ", department=" + group.getIdDepartment() +
                ", phoneNumber=" + phoneNumber +
                ", group=" + group +
                '}';
    }
}
//TODO Как сделать правильно фильтрацию (вьюшку)  чекбокс/список other ?
//TODO Сервлеты с Thymeleaf нормально работает ?
// TODO Где хранить данные о пользователе который залогинился ?
// TODO Как лучше сделать разделение на права студент/админ ( что бы студент по линку не смог добратся до данных).

