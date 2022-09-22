package ru.aberezhnoy.mediator;

public class User {

    private String name;

    private ChatRoomMediator chatMediator;

//    public User() {
//    }

//    public User(String name, ChatRoomMediator chatMediator) {
//        this.name = name;
//        this.chatMediator = chatMediator;
//    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message) {
        this.chatMediator.showMessage(this, message);
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final User user;

        public Builder() {
            this.user = new User();
        }

        public Builder setName(String name) {
            this.user.name = name;
            return this;
        }

        public Builder setMediator(ChatRoomMediator chatMediator) {
            this.user.chatMediator = chatMediator;
            return this;
        }

        public User build() {
            return this.user;
        }
    }
}
