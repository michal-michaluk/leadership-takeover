package io.dddbyexamples.commandandcontrol.leadershiptakeover;

import io.dddbyexamples.commandandcontrol.leadershiptakeover.comands.TakeoverCommand;

class RoleOfNewSuperior {

    public void receive(TakeoverCommand command) {

    }

    public void submit(TakeoverCommandResponse response) {

    }

    public void receive(ACK<TakeoverCommandResponse> ack) {

    }

    public void noACK(TakeoverCommandResponse command) {

    }

    public void receive(StatusReport status) {

    }

    public void noStatus(StatusReport status) {

    }
}
