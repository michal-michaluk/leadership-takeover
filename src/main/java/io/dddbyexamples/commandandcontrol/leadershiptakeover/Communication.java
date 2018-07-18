package io.dddbyexamples.commandandcontrol.leadershiptakeover;

import java.util.function.Consumer;

public interface Communication {
    <T> void send(T toSend,
                  Consumer<T> positive,
                  Consumer<T> negative);
}
