package io.dddbyexamples.commandandcontrol.leadershiptakeover;

import io.dddbyexamples.commandandcontrol.commands.CommandStatusChanged;
import io.dddbyexamples.commandandcontrol.commands.CommandsEvents;
import io.dddbyexamples.commandandcontrol.commands.NewCommandGiven;
import io.dddbyexamples.commandandcontrol.commands.NewCommandReceived;

public class FakeCommandsEventsPropagation implements CommandsEvents {

    // public SentCommandListProjection list;
    // private POpup popup;
    // private Table table;
    // private Map map;

    @Override
    public void emit(NewCommandGiven event) {
        // list.apply(event);
        // map.apply(event);
        // popup.apply(event);
        // table.apply(event);
    }

    @Override
    public void emit(NewCommandReceived event) {

    }

    @Override
    public void emit(CommandStatusChanged event) {

    }
}
