package io.dddbyexamples.commandandcontrol.leadershiptakeover;

import io.dddbyexamples.commandandcontrol.commands.CommandResponse;
import lombok.Value;

@Value
public class ChangeSuperiorResponse {
    ChangeSuperiorCommand command;
    CommandResponse response;
}
