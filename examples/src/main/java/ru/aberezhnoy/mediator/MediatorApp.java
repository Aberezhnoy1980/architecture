package ru.aberezhnoy.mediator;

public class MediatorApp {
    public static void main(String[] args) {
        ChatRoomMediator mediator = new ChatRoom();

        User john = User
                .createBuilder()
                .setName("John")
                .setMediator(mediator)
                .build();

        User jane = User
                .createBuilder()
                .setName("Jane")
                .setMediator(mediator)
                .build();

        john.sendMessage("Hi there!");
        jane.sendMessage("Hey");
    }
}
