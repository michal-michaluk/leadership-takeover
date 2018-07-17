Feature: Planned leadership takeover

  Domain example:
  Jet fighter (Subordinate object) is controlled
  by ground flight control (Current Superior).
  According to plan, on certain point of flight,
  AWAX flaying command center (New Superior)
  should takeover leadership of Jet fighter (Subordinate object).

  # Jak szukać kroków scenariuszy kożystając z Event Stormingu:
  # Given - pomarańczowe które zaszły wcześniej
  # When - niebieskie lub różowe karteczki
  # Then - pomarańczowe karteczki

  # przykład kompletnego scenariusza z perspektywy 3 aktorów
  Scenario: Planned leadership takeover

    # Current Superior
    When Superior command to New Superior to take Leadership over Subordinate
    Then the Takeover Command is send to New Superior
    And the Takeover Command is shown on Sent Command List [on Current Superior]
    And Takeover Command has status "Send" [on Current Superior]

    # New Superior
    When New Superior receive the Takeover Command
    #Then ACK is send
    Then Takeover Command status is shown on Received Commands List [on New Superior]
    And Takeover Command has status "Received" [on New Superior]
    And Subordinate is marked on map [on New Superior]
    And new Takeover Command is shown for operator [on New Superior]

    # Current Superior
    When Superior received ACK
    Then Takeover Command has status "MR Received" [on Current Superior]

    # New Superior operator
    When New Superior confirms Takeover Command
    Then Takeover Command has status "Will Comply" [on New Superior]
    And Takeover Command Confirmation is sent [from New Superior]

    # Current Superior
    When Superior received Takeover Command Confirmation
    #Then ACK is send
    Then Takeover Command has status "Will Comply" [on Current Superior]
    And Control Takeover Command is sent to Subordinate [from Current Superior]

    # New Superior
    When New Superior received ACK
    Then Takeover Command status is not changed, stays in "Will Comply" [on New Superior]

    # Subordinate
    When Subordinate received Control Takeover Command
    #Then ACK is send
    Then Control Takeover Command status is shown on Received Commands List [on Subordinate]
    And Control Takeover Command has status "Received" [on Subordinate]
    And New Superior is marked on map [on Subordinate]
    And new Control Takeover Command is shown for operator [on Subordinate]

    # Current Superior
    When Superior received ACK
    Then Control Takeover Command has status "MR Received" [from Current Superior]

    # Subordinate operator
    When Subordinate confirms Control Takeover Command
    Then Control Takeover Command has status "Will Comply" [on Subordinate]
    And Control Takeover Command Confirmation is sent [from Subordinate]
    And Superior is changed [on Subordinate]
    And Status Report with New Superior is sent [from Subordinate]

    # Current Superior
    When Superior received Control Takeover Command Confirmation
    #Then ACK is send
    Then Control Takeover Command has status "Will Comply" [on Current Superior]

    # Current Superior
    When Status Report with New Superior is received [on Current Superior]
    Then Subordinate is removed from Subordinate List [on Current Superior]
    And Control Takeover Command has status "Completed" [on Current Superior]
    And Takeover Command has status "Completed" [on Current Superior]

    # New Superior
    When Status Report with New Superior is received [on New Superior]
    Then Subordinate is added to Subordinate List [on New Superior]
    And Takeover Command has status "Completed" [on New Superior]

