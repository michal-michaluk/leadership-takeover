package io.dddbyexamples.commandandcontrol.leadershiptakeover.superior;

import io.dddbyexamples.commandandcontrol.leadershiptakeover.ChangeSuperiorResponse;
import io.dddbyexamples.commandandcontrol.leadershiptakeover.TakeControlCommand;
import io.dddbyexamples.commandandcontrol.leadershiptakeover.TakeControlResponse;
import io.dddbyexamples.commandandcontrol.status.StatusReport;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SuperiorService {

    private SuperiorRepository repository;

    public void giveTakeControlCommand(TakeControlCommand command) {
        repository.get(command.getSubordinateId())
                .giveTakeControlCommand(command);
    }

    public void receiveFromNewSuperior(TakeControlResponse response) {
        repository.get(response.getCommand().getSubordinateId())
                .receiveFromNewSuperior(response);
    }

    public void receiveFromSubordinate(ChangeSuperiorResponse response) {
        repository.get(response.getCommand().getSubordinateId())
                .receiveFromSubordinate(response);
    }

    public void receiveFromSubordinate(StatusReport status) {
        repository.get(status.getObjectId())
                .receiveFromSubordinate(status);
    }
}
