package io.dddbyexamples.commandandcontrol.leadershiptakeover.comands;

import lombok.Value;

@Value
public class TakeoverCommand {
    int newSuperiorId;
    int subordinateId;
}
