package io.dddbyexamples.commandandcontrol.status;

import lombok.Value;

@Value
public class StatusReport {
    int objectId;
    int superiorId;
}
