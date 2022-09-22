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

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
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
