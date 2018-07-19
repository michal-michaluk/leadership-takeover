package io.dddbyexamples.commandandcontrol.leadershiptakeover;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.dddbyexamples.commandandcontrol.leadershiptakeover.newsuperior.RoleOfNewSuperior;
import io.dddbyexamples.commandandcontrol.leadershiptakeover.subordinate.RoleOfSubordinate;
import io.dddbyexamples.commandandcontrol.leadershiptakeover.superior.RoleOfSuperior;

public class PlannedLeadershipTakeoverSteps {

    // dependencies
    private FakeLeadershipTakeoverCommunication communication = new FakeLeadershipTakeoverCommunication();
    private FakeCommandsEventsPropagation events = new FakeCommandsEventsPropagation();

    // objects under tests
    private RoleOfSuperior superior;
    private RoleOfNewSuperior newSuperior;
    private RoleOfSubordinate subordinate;

    @Before
    public void setUp() throws Exception {
        superior = new RoleOfSuperior(communication, events);
        newSuperior = new RoleOfNewSuperior(communication, events);
        subordinate = new RoleOfSubordinate(communication, events);
    }

    @When("^Superior command to New Superior to Take Control over Subordinate$")
    public void superiorCommandToNewSuperiorToTakeControlOverSubordinate() throws Throwable {
        superior.giveTakeControlCommand(new TakeControlCommand(2, 3));
    }

    @When("^New Superior receive the Take Control Command$")
    public void newSuperiorReceiveTheTakeoverCommand() throws Throwable {
        newSuperior.receiveCommandFromOtherC2(communication.lastTakeControlCommand());
    }

    @When("^Superior received Take Control Command Acknowledge")
    public void superiorReceivedTakeoverCommandACK() throws Throwable {
        communication.takeControlAcknowledged();
    }

    @When("^New Superior accepts Take Control Command$")
    public void newSuperiorConfirmsTakeoverCommand() throws Throwable {
        newSuperior.acceptTakeControl();
    }

    @When("^Superior received acceptation of Take Control Command")
    public void superiorReceivedTakeoverCommandConfirmation() throws Throwable {
        superior.receiveFromNewSuperior(communication.lastTakeoverCommandResponse());
    }

    @When("^New Superior received Take Control Response Acknowledge")
    public void newSuperiorReceivedTakeoverCommandResponseACK() throws Throwable {
        communication.takeControlResponseAcknowledged();
    }

    @When("^Subordinate received Change Superior Command$")
    public void subordinateReceivedControlTakeoverCommand() throws Throwable {
        subordinate.receiveCommandFromSuperior(communication.lastChangeSuperiorCommand());
    }

    @When("^Superior received Change Superior Command Acknowledge$")
    public void superiorReceivedControlTakeoverCommandACK() throws Throwable {
        communication.changeSuperiorCommandAcknowledged();
    }

    @When("^Subordinate confirms Change Superior Command$")
    public void subordinateConfirmsControlTakeoverCommand() throws Throwable {
        subordinate.confirmChangeSuperiorCommand();
    }

    @When("^Superior received confirmation of Change Superior Command")
    public void superiorReceivedControlTakeoverCommandConfirmation() throws Throwable {
        superior.receiveFromSubordinate(communication.lastChangeSuperiorResponse());
    }

    @When("^Status Report with New Superior is received \\[on Current Superior]$")
    public void statusReportWithNewSuperiorIsReceivedOnCurrentSuperior() throws Throwable {
        superior.receiveFromSubordinate(communication.lastStatusReport());
    }

    @When("^Status Report with New Superior is received \\[on New Superior]$")
    public void statusReportWithNewSuperiorIsReceivedOnNewSuperior() throws Throwable {
        newSuperior.receiveFromSubordinate(communication.lastStatusReport());
    }

    @Then("^Take Control Command has status \"([^\"]*)\" \\[on Current Superior]$")
    public void takeControlCommandHasStatusOnCurrentSuperior(String status) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Take Control Command has status \"([^\"]*)\" \\[on New Superior]$")
    public void takeControlCommandHasStatusOnNewSuperior(String status) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Take Control status is not changed, stays in \"([^\"]*)\" \\[on New Superior]$")
    public void takeControlStatusIsNotChangedStaysInOnNewSuperior(String status) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Status Report with New Superior is sent \\[from Subordinate]$")
    public void statusReportWithNewSuperiorIsSentFromSubordinate() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Change Superior Command has status \"([^\"]*)\" \\[on Subordinate]$")
    public void changeSuperiorCommandHasStatusOnSubordinate(String status) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Change Superior Command has status \"([^\"]*)\" \\[from Current Superior]$")
    public void changeSuperiorCommandHasStatusFromCurrentSuperior(String status) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Change Superior Command has status \"([^\"]*)\" \\[on Current Superior]$")
    public void changeSuperiorCommandHasStatusOnCurrentSuperior(String status) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^New Superior is marked on map \\[on Subordinate]$")
    public void newSuperiorIsMarkedOnMapOnSubordinate() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Superior is changed \\[on Subordinate]$")
    public void superiorIsChangedOnSubordinate() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the Take Control is send to New Superior$")
    public void theTakeControlIsSendToNewSuperior() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Change Superior Command Confirmation is sent \\[from Subordinate]$")
    public void changeSuperiorCommandConfirmationIsSentFromSubordinate() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Take Control Command Confirmation is sent \\[from New Superior]$")
    public void takeControlCommandConfirmationIsSentFromNewSuperior() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Change Superior Command is sent to Subordinate \\[from Current Superior]$")
    public void changeSuperiorCommandIsSentToSubordinateFromCurrentSuperior() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Subordinate is removed from Subordinate List \\[on Current Superior]$")
    public void subordinateIsRemovedFromSubordinateListOnCurrentSuperior() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Subordinate is added to Subordinate List \\[on New Superior]$")
    public void subordinateIsAddedToSubordinateListOnNewSuperior() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
