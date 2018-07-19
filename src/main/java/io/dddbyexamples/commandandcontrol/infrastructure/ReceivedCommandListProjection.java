package io.dddbyexamples.commandandcontrol.infrastructure;

import io.dddbyexamples.commandandcontrol.commands.NewCommandReceived;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReceivedCommandListProjection {

    public void apply(NewCommandReceived event) {

    }
}
