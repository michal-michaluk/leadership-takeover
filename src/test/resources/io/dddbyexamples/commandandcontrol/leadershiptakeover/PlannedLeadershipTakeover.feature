Feature: Planned leadership takeover

  # Given - pomarańczowe które zaszły wcześniej
  # When - niebieskie lub różowe karteczki
  # Then - pomarańczowe karteczki

  Scenario: Planned leadership takeover

    # Current Superior
    When Superior command to New Superior to take Leadership over Subordinate
    Then the Takeover Command is send to New Superior
    And the Takeover Command is shown on Sent Command List
    And Takeover Command has status "Send"

    # New Superior
    When New Superior receive the Takeover Command
    Then ACK is send
    And Takeover Command status is shown on Received Commands List
    And Takeover Command has status "Received"
    And Subordinate is marked on map
    And new Takeover Command is shown for operator

    # Current Superior
    When Superior received ACK
    Then Takeover Command has status "MR Received"

    # New Superior operator
    When New Superior confirms Takeover Command
    Then Takeover Command has status "Will Comply"
    And Takeover Command Confirmation is sent

    # Current Superior
    When Superior received Takeover Command Confirmation
    Then ACK is send
    And Takeover Command has status "Will Comply"
    And Control Takeover Command is sent to Subordinate

    # New Superior
    When New Superior received ACK
    Then Takeover Command status is not changed, stays in "Will Comply"

    # Subordinate
    When Subordinate received Control Takeover Command
    Then ACK is send
    And Control Takeover Command status is shown on Received Commands List
    And Control Takeover Command has status "Received"
    And New Superior is marked on map
    And new Control Takeover Command is shown for operator

    # Current Superior
    When Superior received ACK
    Then Control Takeover Command has status "MR Received"

    # Subordinate operator
    When Subordinate confirms Control Takeover Command
    Then Control Takeover Command has status "Will Comply"
    And Control Takeover Command Confirmation is sent
    And Superior is changed
    And Status Report with New Superior is sent

    # Current Superior
    When Superior received Control Takeover Command Confirmation
    Then ACK is send
    And Control Takeover Command has status "Will Comply"

    # Current Superior
    When Status Report with New Superior is received
    Then Subordinate is removed from Subordinate List
    And Control Takeover Command has status "Completed"
    And Takeover Command has status "Completed"

    # New Superior
    When Status Report with New Superior is received
    Then Subordinate is added to Subordinate List
    And Takeover Command has status "Completed"

#Daniel i Paweł

  Scenario: Current Superior did not send Takeover Command to New Superior
      #CS tried to send command but did not received ACK
      #status CS: Send ... Timeout

  Scenario: New Superior send rejection Takeover Command to Current Superior
      #status NS: Received -> Rejected

  Scenario: New Superior did not send confirmation Takeover Command to Current Superior
      #NS tried to send confirmation but did not received ACK
      #status NS: Received -> Will Comply

  Scenario: New Superior did not send rejection Takeover Command to Current Superior
      #NS tried to send rejection but did not received ACK
      #status CS: Send -> MR Received ... Timeout

  Scenario: Current Superior did not send Control Takeover Command to Subordinate
      #CS tried to send command but did not received ACK
      #status CS: Send ... Timeout

  Scenario: Subordinate did not confirm Control Takeover Command
      #status CS: Send -> MR Received ... Timeout
      #status S:  Received

  Scenario: Subordinate did not send confirmation Control Takeover Command
      #S tried to send confirmation but did not received ACK
      #status S: Received -> Will Comply ... Timeout


