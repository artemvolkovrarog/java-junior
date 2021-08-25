package com.acme.edu.messages;

public abstract class Message {
    protected String message_type;

    public Message(Object message) {
        if (message instanceof Character) {
            message_type = "char";
        } else if (message instanceof Integer) {
            message_type = "primitive";
        } else if (message instanceof Byte) {
            message_type = "primitive";
        } else if (message instanceof Boolean) {
            message_type = "primitive";
        } else if (message instanceof String) {
            message_type = "string";
        } else if (message instanceof Object) {
            message_type = "reference";
        }
    }

    public abstract String wrapMessage();
}
