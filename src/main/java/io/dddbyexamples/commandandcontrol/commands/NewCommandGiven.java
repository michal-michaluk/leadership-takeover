package io.dddbyexamples.commandandcontrol.commands;

import lombok.Value;

@Value
public class NewCommandGiven {
    String command;
    String status;
}
