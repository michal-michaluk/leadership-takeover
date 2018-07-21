Feature: Planned leadership takeover

  Domain example:
  Jet fighter (Subordinate object) is controlled
  by ground flight control (Current Superior).
  According to plan, on certain point of flight,
  AWACS flaying command center (New Superior)
  should takeover leadership of Jet fighter (Subordinate object).

  # Jak szukać kroków scenariuszy kożystając z Event Stormingu:
  # Given - pomarańczowe które zaszły wcześniej
  # When - niebieskie lub różowe karteczki
  # Then - pomarańczowe karteczki

  # przykład kompletnego scenariusza z perspektywy 3 aktorów
  Scenario: Planned leadership takeover

    # Current Superior
    When Superior command to New Superior to Take Control over Subordinate
    Then the Take Control is send to New Superior
    #And the Take Control is shown on Sent Command List [on Current Superior]
    And Take Control Command has status "Send" [on Current Superior]

    # New Superior
    When New Superior receive the Take Control Command
    #Then ACK is send
    #Then Take Control status is shown on Received Commands List [on New Superior]
    And Take Control Command has status "Received" [on New Superior]
    #And Subordinate is marked on map [on New Superior]
    #And new Take Control Command is shown for operator [on New Superior]

    # Current Superior
    When Superior received Take Control Command Acknowledge
    Then Take Control Command has status "MR Received" [on Current Superior]

    # New Superior operator
    When New Superior accepts Take Control Command
    Then Take Control Command has status "Will Comply" [on New Superior]
    And Take Control Command Confirmation is sent [from New Superior]

    # Current Superior
    When Superior received acceptation of Take Control Command
    #Then ACK is send
    Then Take Control Command has status "Will Comply" [on Current Superior]
    And Change Superior Command is sent to Subordinate [from Current Superior]

    # New Superior
    When New Superior received Take Control Response Acknowledge
    Then Take Control status is not changed, stays in "Will Comply" [on New Superior]

    # Subordinate
    When Subordinate received Change Superior Command
    #Then ACK is send
    #Then Change Superior Command status is shown on Received Commands List [on Subordinate]
    And Change Superior Command has status "Received" [on Subordinate]
    And New Superior is marked on map [on Subordinate]
    #And new Change Superior Command is shown for operator [on Subordinate]

    # Current Superior
    When Superior received Change Superior Command Acknowledge
    Then Change Superior Command has status "MR Received" [from Current Superior]

    # Subordinate operator
    When Subordinate confirms Change Superior Command
    Then Change Superior Command has status "Will Comply" [on Subordinate]
    And Change Superior Command Confirmation is sent [from Subordinate]
    And Superior is changed [on Subordinate]
    And Status Report with New Superior is sent [from Subordinate]

    # Current Superior
    When Superior received confirmation of Change Superior Command
    #Then ACK is send
    Then Change Superior Command has status "Will Comply" [on Current Superior]

    # Current Superior
    When Status Report with New Superior is received [on Current Superior]
    Then Subordinate is removed from Subordinate List [on Current Superior]
    And Change Superior Command has status "Completed" [on Current Superior]
    And Take Control Command has status "Completed" [on Current Superior]

    # New Superior
    When Status Report with New Superior is received [on New Superior]
    Then Subordinate is added to Subordinate List [on New Superior]
    And Take Control Command has status "Completed" [on New Superior]

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


