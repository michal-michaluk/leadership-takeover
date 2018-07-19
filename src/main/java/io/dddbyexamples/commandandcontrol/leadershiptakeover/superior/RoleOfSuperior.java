package io.dddbyexamples.commandandcontrol.leadershiptakeover.superior;

import io.dddbyexamples.commandandcontrol.commands.CommandsEvents;
import io.dddbyexamples.commandandcontrol.commands.NewCommandGiven;
import io.dddbyexamples.commandandcontrol.leadershiptakeover.*;
import io.dddbyexamples.commandandcontrol.status.StatusReport;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RoleOfSuperior {

    private LeadershipTakeoverCommunication communication;
    private CommandsEvents events;

    public void giveTakeControlCommand(TakeControlCommand command) {
        communication.send(command, this::ack, this::noACK);
        events.emit(new NewCommandGiven("TakeControlCommand", "Send"));
    }

    private void ack(TakeControlCommand message) {

    }

    private void noACK(TakeControlCommand message) {

    }

    public void receiveFromNewSuperior(TakeControlResponse response) {

    }

    private void ack(ChangeSuperiorCommand message) {

    }

    private void noACK(ChangeSuperiorCommand message) {

    }

    public void receiveFromSubordinate(ChangeSuperiorResponse response) {

    }

    public void receiveFromSubordinate(StatusReport status) {

    }
}
