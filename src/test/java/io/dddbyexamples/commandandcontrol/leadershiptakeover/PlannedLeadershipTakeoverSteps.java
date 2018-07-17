package io.dddbyexamples.commandandcontrol.leadershiptakeover;

import cucumber.api.java.en.When;
import io.dddbyexamples.commandandcontrol.leadershiptakeover.comands.TakeoverCommand;

public class PlannedLeadershipTakeoverSteps {

    RoleOfSuperior superior;
    RoleOfNewSuperior newSuperior;
    RoleOfSubordinate subordinate;

    private int superiorId;
    private int newSuperiorId;
    private int subordinateId;
    private TakeoverCommandRespond takeoverCommandRespond;
    private TakeoverCommand takeoverCommand;

    @When("^Superior command to New Superior to take Leadership over Subordinate$")
    public void superiorCommandToNewSuperiorToTakeLeadershipOverSubordinate() throws Throwable {
        takeoverCommand = new TakeoverCommand(newSuperiorId, subordinateId);
        superior.submit(takeoverCommand);
    }

    @When("^New Superior receive the Takeover Command$")
    public void newSuperiorReceiveTheTakeoverCommand() throws Throwable {
        newSuperior.receive(takeoverCommand);
    }

    @When("^Superior received ACK$")
    public void superiorReceivedACK() throws Throwable {
        superior.receive(new ACK<>(takeoverCommand));
    }

    @When("^New Superior confirms Takeover Command$")
    public void newSuperiorConfirmsTakeoverCommand() throws Throwable {
        takeoverCommandRespond = new TakeoverCommandRespond(takeoverCommand, Response.ACCEPT);
        //newSuperior.submit(takeoverCommandRespond);
        //newSuperior.submit(new TakeoverCommandRespond(takeoverCommandId, DECLINE));
    }

    @When("^Superior received Takeover Command Confirmation$")
    public void superiorReceivedTakeoverCommandConfirmation() throws Throwable {
        //superior.receive(takeoverCommandRespond);
    }

    @When("^New Superior received ACK$")
    public void newSuperiorReceivedACK() throws Throwable {
        //superior.receive(new ACK(takeoverRespondId));
    }

    @When("^Subordinate received Control Takeover Command$")
    public void subordinateReceivedControlTakeoverCommand() throws Throwable {
        //subordinate.receive(new ControlTakeoverCommand(superiorId, newSuperiorId));
    }

    @When("^Subordinate confirms Control Takeover Command$")
    public void subordinateConfirmsControlTakeoverCommand() throws Throwable {
        //subordinate.submit(new ControlTakeoverCommandRespond(takeoverCommandId, Response.ACCEPT));
    }

    @When("^Superior received Control Takeover Command Confirmation$")
    public void superiorReceivedControlTakeoverCommandConfirmation() throws Throwable {
        //superior.receive(new ControlTakeoverCommandRespond(takeoverCommandId, Response.ACCEPT));
    }

    @When("^Status Report with New Superior is received \\[on Current Superior\\]$")
    public void statusReportWithNewSuperiorIsReceivedOnCurrentSuperior() throws Throwable {
        //superior.receive(new StatusReport(subordinateId, newSuperiorId));
    }

    @When("^Status Report with New Superior is received \\[on New Superior\\]$")
    public void statusReportWithNewSuperiorIsReceivedOnNewSuperior() throws Throwable {
        //newSuperior.receive(new StatusReport(subordinateId, newSuperiorId));
    }
}
