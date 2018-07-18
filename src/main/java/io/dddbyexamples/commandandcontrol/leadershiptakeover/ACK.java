package io.dddbyexamples.commandandcontrol.leadershiptakeover;

import lombok.Value;

@Value
class ACK<COMMAND> {
    COMMAND command;
}
