package lesson6.task4.domain;

public class UserFactory {
    User user;

    public UserFactory(User user) {
        this.user = user;
    }

    User cloneUser() {
        return (User) user.copy();
    }
}
