package io.dddbyexamples.commandandcontrol.leadershiptakeover;

import cucumber.api.java.en.When;
import io.dddbyexamples.commandandcontrol.leadershiptakeover.comands.TakeoverCommand;

public class PlannedLeadershipTakeoverSteps {

    private RoleOfSuperior superior;
    private RoleOfNewSuperior newSuperior;
    private RoleOfSubordinate subordinate;

    private int superiorId = 1;
    private int newSuperiorId = 2;
    private int subordinateId = 3;

    private TakeoverCommandResponse takeoverCommandResponse;
    private TakeoverCommand takeoverCommand;
    private ControlTakeoverCommand controlTakeoverCommand;
    private ControlTakeoverCommandResponse controlTakeoverCommandResponse;

    @When("^Superior command to New Superior to take Leadership over Subordinate$")
    public void superiorCommandToNewSuperiorToTakeLeadershipOverSubordinate() throws Throwable {
        takeoverCommand = new TakeoverCommand(newSuperiorId, subordinateId);
        superior.submit(takeoverCommand);
    }

    @When("^New Superior receive the Takeover Command$")
    public void newSuperiorReceiveTheTakeoverCommand() throws Throwable {
        newSuperior.receive(takeoverCommand);
    }

    @When("^Superior received Takeover Command ACK$")
    public void superiorReceivedTakeoverCommandACK() throws Throwable {
        superior.receive(new ACK<>(takeoverCommand));
    }

    @When("^New Superior confirms Takeover Command$")
    public void newSuperiorConfirmsTakeoverCommand() throws Throwable {
        takeoverCommandResponse = new TakeoverCommandResponse(takeoverCommand, Response.ACCEPT);
        newSuperior.submit(takeoverCommandResponse);
    }

    @When("^Superior received Takeover Command Confirmation$")
    public void superiorReceivedTakeoverCommandConfirmation() throws Throwable {
        superior.receive(takeoverCommandResponse);
    }

    @When("^New Superior received Takeover Command Response ACK$")
    public void newSuperiorReceivedTakeoverCommandResponseACK() throws Throwable {
        newSuperior.receive(new ACK<>(takeoverCommandResponse));

    }

    @When("^Subordinate received Control Takeover Command$")
    public void subordinateReceivedControlTakeoverCommand() throws Throwable {
        controlTakeoverCommand = new ControlTakeoverCommand(superiorId, newSuperiorId);
        subordinate.receive(controlTakeoverCommand);
    }

    @When("^Superior received Control Takeover Command ACK$")
    public void superiorReceivedControlTakeoverCommandACK() throws Throwable {
        superior.receive2(new ACK<>(controlTakeoverCommand));
    }

    @When("^Subordinate confirms Control Takeover Command$")
    public void subordinateConfirmsControlTakeoverCommand() throws Throwable {
        controlTakeoverCommandResponse = new ControlTakeoverCommandResponse(controlTakeoverCommand, Response.ACCEPT);
        subordinate.submit(controlTakeoverCommandResponse);
    }

    @When("^Superior received Control Takeover Command Confirmation$")
    public void superiorReceivedControlTakeoverCommandConfirmation() throws Throwable {
        superior.receive(controlTakeoverCommandResponse);
    }

    @When("^Status Report with New Superior is received \\[on Current Superior]$")
    public void statusReportWithNewSuperiorIsReceivedOnCurrentSuperior() throws Throwable {
        superior.receive(new StatusReport(subordinateId, newSuperiorId));
    }

    @When("^Status Report with New Superior is received \\[on New Superior]$")
    public void statusReportWithNewSuperiorIsReceivedOnNewSuperior() throws Throwable {
        newSuperior.receive(new StatusReport(subordinateId, newSuperiorId));
    }
}
