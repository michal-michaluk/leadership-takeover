package io.dddbyexamples.commandandcontrol.leadershiptakeover;

import io.dddbyexamples.commandandcontrol.leadershiptakeover.comands.TakeoverCommand;

public class RoleOfSuperior {

    public void submit(TakeoverCommand command) {

    }

    public void receive(ACK<TakeoverCommand> ack) {

    }

    public void noACK(TakeoverCommand command) {

    }

    public void receive(TakeoverCommandResponse response) {

    }

    public void receive(ControlTakeoverCommandResponse response) {

    }

    public void receive(StatusReport status) {

    }

    public void noStatus(StatusReport status) {

    }

    public void receive2(ACK<ControlTakeoverCommand> ack) {

    }
}
