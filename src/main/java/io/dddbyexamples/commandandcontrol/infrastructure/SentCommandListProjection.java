package io.dddbyexamples.commandandcontrol.infrastructure;

import io.dddbyexamples.commandandcontrol.commands.NewCommandGiven;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SentCommandListProjection {

    public void apply(NewCommandGiven event) {

    }
}
