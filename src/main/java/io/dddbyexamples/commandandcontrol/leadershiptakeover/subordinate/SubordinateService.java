package io.dddbyexamples.commandandcontrol.leadershiptakeover.subordinate;

import io.dddbyexamples.commandandcontrol.leadershiptakeover.ChangeSuperiorCommand;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SubordinateService {

    private SubordinateRepository repository;

    public void receiveCommandFromSuperior(ChangeSuperiorCommand command) {
        repository.get(command.getNewSuperiorId())
                .receiveCommandFromSuperior(command);
    }

    public void confirmChangeSuperiorCommand(ChangeSuperiorCommand command) {
        repository.get(command.getNewSuperiorId())
                .confirmChangeSuperiorCommand();
    }
}
