package io.dddbyexamples.commandandcontrol.leadershiptakeover;

public interface Events {
    void emit(NewCommand event);
}
