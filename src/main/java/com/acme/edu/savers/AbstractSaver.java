package com.acme.edu.savers;

import com.acme.edu.checkers.IntSequenceChecker;
import com.acme.edu.checkers.StringSequenceChecker;
import com.acme.edu.messages.IntMessage;
import com.acme.edu.messages.Message;
import com.acme.edu.messages.StringMessage;

public abstract class AbstractSaver implements Saver {
    private StringSequenceChecker stringChecker;
    private IntSequenceChecker intChecker;

    @Override
    public void save(String message) {}

    @Override
    public void save(Message message) {
        if ( !InstanceOfSpecialTypes(message) ) {
            this.save(message.getType() + ": " + message.getValue());
        }
        stringChecker.check(message.getValue());
        intChecker.check(message.getValue());
    }

    @Override
    public void setCheckers(IntSequenceChecker intChecker, StringSequenceChecker stringChecker) {
        this.stringChecker = stringChecker;
        this.intChecker = intChecker;
    }

    private boolean InstanceOfSpecialTypes(Message message) {
        return (message instanceof StringMessage ||
                message instanceof IntMessage);
    }
}