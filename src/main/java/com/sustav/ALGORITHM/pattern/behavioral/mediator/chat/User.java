package com.sustav.ALGORITHM.pattern.behavioral.mediator.chat;

public abstract class User {
    protected ChatMediator chatMediator;
    protected String name;

    public User(ChatMediator chatMediator, String name) {
        this.chatMediator = chatMediator;
        this.name = name;
    }

    public abstract void send(String msg);
    public abstract void receive(String msg);
}
