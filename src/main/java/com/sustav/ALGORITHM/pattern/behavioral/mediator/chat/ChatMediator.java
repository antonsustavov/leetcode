package com.sustav.ALGORITHM.pattern.behavioral.mediator.chat;

public interface ChatMediator {
    void sendMessage(String msg, User user);
    void addUser(User user);
}
