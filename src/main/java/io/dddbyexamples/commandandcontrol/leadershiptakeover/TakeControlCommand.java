package io.dddbyexamples.commandandcontrol.leadershiptakeover;

import lombok.Value;

@Value
public class TakeControlCommand {
    int newSuperiorId;
    int subordinateId;
}
