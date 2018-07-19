package io.dddbyexamples.commandandcontrol.leadershiptakeover.subordinate;

import io.dddbyexamples.commandandcontrol.commands.CommandsEvents;
import io.dddbyexamples.commandandcontrol.leadershiptakeover.ChangeSuperiorCommand;
import io.dddbyexamples.commandandcontrol.leadershiptakeover.LeadershipTakeoverCommunication;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RoleOfSubordinate {

    private LeadershipTakeoverCommunication communication;
    private CommandsEvents events;

    public void receiveCommandFromSuperior(ChangeSuperiorCommand command) {

    }

    public void confirmChangeSuperiorCommand() {

    }
}
