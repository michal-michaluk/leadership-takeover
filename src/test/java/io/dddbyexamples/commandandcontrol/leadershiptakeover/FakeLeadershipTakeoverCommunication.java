package io.dddbyexamples.commandandcontrol.leadershiptakeover;

import io.dddbyexamples.commandandcontrol.status.StatusReport;
import lombok.AllArgsConstructor;

import java.util.function.Consumer;

public class FakeLeadershipTakeoverCommunication implements LeadershipTakeoverCommunication {

    @AllArgsConstructor
    private class SentInfo<T> {
        T message;
        Consumer<T> positive;
        Consumer<T> negative;
    }

    private SentInfo<TakeControlCommand> takeControlCommand;
    private SentInfo<TakeControlResponse> takeControlResponse;
    private SentInfo<ChangeSuperiorCommand> changeSuperiorCommand;
    private SentInfo<ChangeSuperiorResponse> changeSuperiorResponse;
    private SentInfo<StatusReport> statusReport;

    @Override
    public void send(TakeControlCommand toSend, Consumer<TakeControlCommand> positive, Consumer<TakeControlCommand> negative) {
        takeControlCommand = new SentInfo<>(toSend, positive, negative);
    }

    @Override
    public void send(TakeControlResponse toSend, Consumer<TakeControlResponse> positive, Consumer<TakeControlResponse> negative) {
        takeControlResponse = new SentInfo<>(toSend, positive, negative);
    }

    @Override
    public void send(ChangeSuperiorCommand toSend, Consumer<ChangeSuperiorCommand> positive, Consumer<ChangeSuperiorCommand> negative) {
        changeSuperiorCommand = new SentInfo<>(toSend, positive, negative);
    }

    @Override
    public void send(ChangeSuperiorResponse toSend, Consumer<ChangeSuperiorResponse> positive, Consumer<ChangeSuperiorResponse> negative) {
        changeSuperiorResponse = new SentInfo<>(toSend, positive, negative);
    }

    @Override
    public void send(StatusReport toSend, Consumer<StatusReport> positive, Consumer<StatusReport> negative) {
        statusReport = new SentInfo<>(toSend, positive, negative);
    }

    public TakeControlCommand lastTakeControlCommand() {
        return takeControlCommand.message;
    }

    public TakeControlResponse lastTakeoverCommandResponse() {
        return takeControlResponse.message;
    }

    public ChangeSuperiorCommand lastChangeSuperiorCommand() {
        return changeSuperiorCommand.message;
    }

    public ChangeSuperiorResponse lastChangeSuperiorResponse() {
        return changeSuperiorResponse.message;
    }

    public StatusReport lastStatusReport() {
        return statusReport.message;
    }

    public void takeControlAcknowledged() {
        takeControlCommand.positive.accept(takeControlCommand.message);
    }

    public void takeControlResponseAcknowledged() {
        takeControlResponse.positive.accept(takeControlResponse.message);
    }

    public void changeSuperiorCommandAcknowledged() {
        changeSuperiorCommand.positive.accept(changeSuperiorCommand.message);
    }

    public void changeSuperiorResponseAcknowledged() {
        changeSuperiorResponse.positive.accept(changeSuperiorResponse.message);
    }

    public void statusReportAcknowledged() {
        statusReport.positive.accept(statusReport.message);
    }

    public void takeControlCommandLost() {
        takeControlCommand.negative.accept(takeControlCommand.message);
    }

    public void takeControlResponseLost() {
        takeControlResponse.negative.accept(takeControlResponse.message);
    }

    public void changeSuperiorCommandLost() {
        changeSuperiorCommand.negative.accept(changeSuperiorCommand.message);
    }

    public void changeSuperiorResponseLost() {
        changeSuperiorResponse.negative.accept(changeSuperiorResponse.message);
    }

    public void statusReportLost() {
        statusReport.negative.accept(statusReport.message);
    }
}
