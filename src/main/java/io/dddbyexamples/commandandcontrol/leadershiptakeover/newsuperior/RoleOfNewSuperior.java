package io.dddbyexamples.commandandcontrol.leadershiptakeover.newsuperior;

import io.dddbyexamples.commandandcontrol.commands.CommandsEvents;
import io.dddbyexamples.commandandcontrol.leadershiptakeover.LeadershipTakeoverCommunication;
import io.dddbyexamples.commandandcontrol.leadershiptakeover.TakeControlCommand;
import io.dddbyexamples.commandandcontrol.status.StatusReport;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RoleOfNewSuperior {

    private LeadershipTakeoverCommunication communication;
    private CommandsEvents events;

    public void receiveCommandFromOtherC2(TakeControlCommand command) {

    }

    public void acceptTakeControl() {

    }

    public void rejectTakeControl() {

    }

    public void receiveFromSubordinate(StatusReport status) {

    }
}
