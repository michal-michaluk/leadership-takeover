package io.dddbyexamples.commandandcontrol.leadershiptakeover;

import io.dddbyexamples.commandandcontrol.commands.CommandResponse;
import lombok.Value;

@Value
public class TakeControlResponse {
    TakeControlCommand command;
    CommandResponse response;
}
