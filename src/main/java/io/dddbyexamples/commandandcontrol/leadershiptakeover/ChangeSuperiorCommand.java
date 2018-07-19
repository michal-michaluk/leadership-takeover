package io.dddbyexamples.commandandcontrol.leadershiptakeover;

import lombok.Value;

@Value
public class ChangeSuperiorCommand {
    int subordinateId;
    int superiorId;
    int newSuperiorId;
}
