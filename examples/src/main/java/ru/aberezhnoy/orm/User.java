package ru.aberezhnoy.orm;

public class User {

    private Long id;

    private String login;

    private String password;

    public static Builder createUser() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("id: %d | login: %s | password: %s%n", id, login, password);
    }

    public static class Builder {

        private final User user;

        public Builder() {
            this.user = new User();
        }

        public Builder setId(Long id) {
            this.user.id = id;
            return this;
        }

        public Builder setLogin(String login) {
            this.user.login = login;
            return this;
        }

        public Builder setPassword(String password) {
            this.user.password = password;
            return this;
        }

        public User build() {
            return this.user;
        }
    }
}
