package io.dddbyexamples.commandandcontrol.leadershiptakeover;

import io.dddbyexamples.commandandcontrol.leadershiptakeover.comands.TakeoverCommand;


public class RoleOfSuperior {

    // ports:
    private Communication communication;
    private Events events;

    private NewCommand sent;

    public void submit(TakeoverCommand command) {
        // Then the Takeover Command is send to New Superior
        // And the Takeover Command is shown on Sent Command List [on Current Superior]
        // And Takeover Command has status "Send" [on Current Superior]
        communication.send(command, this::ack, this::noACK);
        sent = new NewCommand(command, "Send");
        events.emit(sent);
    }

    private void ack(TakeoverCommand ack) {
        events.emit(sent);

    }

    private void noACK(TakeoverCommand command) {

    }

    public void receive(TakeoverCommandResponse response) {

    }

    public void noResponse(TakeoverCommandResponse response) {

    }

    public void receive(ControlTakeoverCommandResponse response) {

    }

    public void noResponse(ControlTakeoverCommandResponse response) {

    }

    public void receive(StatusReport status) {

    }

    public void noStatus(StatusReport status) {

    }

    public void receive2(ACK<ControlTakeoverCommand> ack) {

    }
}
