package ru.aberezhnoy.mediator;

import java.time.*;

public class ChatRoom implements ChatRoomMediator {
    @Override
    public void showMessage(User user, String message) {
//        LocalDateTime dateTime;
//        String sender = user.getName();

        System.out.println(LocalDateTime.now() + " : " + " [" + user.getName() + "] " + message);
    }
}







