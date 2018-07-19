package io.dddbyexamples.commandandcontrol.leadershiptakeover;

import io.dddbyexamples.commandandcontrol.status.StatusReport;

import java.util.function.Consumer;

public interface LeadershipTakeoverCommunication {
    void send(TakeControlCommand message,
              Consumer<TakeControlCommand> positive,
              Consumer<TakeControlCommand> negative);

    void send(TakeControlResponse message,
              Consumer<TakeControlResponse> positive,
              Consumer<TakeControlResponse> negative);

    void send(ChangeSuperiorCommand message,
              Consumer<ChangeSuperiorCommand> positive,
              Consumer<ChangeSuperiorCommand> negative);

    void send(ChangeSuperiorResponse message,
              Consumer<ChangeSuperiorResponse> positive,
              Consumer<ChangeSuperiorResponse> negative);

    void send(StatusReport message,
              Consumer<StatusReport> positive,
              Consumer<StatusReport> negative);
}
