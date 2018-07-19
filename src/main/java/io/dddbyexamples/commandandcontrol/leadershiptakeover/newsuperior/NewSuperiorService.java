package io.dddbyexamples.commandandcontrol.leadershiptakeover.newsuperior;

import io.dddbyexamples.commandandcontrol.leadershiptakeover.TakeControlCommand;
import io.dddbyexamples.commandandcontrol.status.StatusReport;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NewSuperiorService {

    private NewSuperiorRepository repository;

    public void receiveCommandFromOtherC2(TakeControlCommand command) {
        repository.get(command.getSubordinateId())
                .receiveCommandFromOtherC2(command);
    }

    public void acceptTakeControl(TakeControlCommand command) {
        repository.get(command.getSubordinateId())
                .acceptTakeControl();
    }

    public void rejectTakeControl(TakeControlCommand command) {
        repository.get(command.getSubordinateId())
                .rejectTakeControl();
    }

    public void receiveFromSubordinate(StatusReport status) {
        repository.get(status.getObjectId())
                .rejectTakeControl();
    }
}
