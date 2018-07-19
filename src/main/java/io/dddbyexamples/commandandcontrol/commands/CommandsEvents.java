package io.dddbyexamples.commandandcontrol.commands;

public interface CommandsEvents {
    void emit(NewCommandGiven event);

    void emit(NewCommandReceived event);

    void emit(CommandStatusChanged event);
}
