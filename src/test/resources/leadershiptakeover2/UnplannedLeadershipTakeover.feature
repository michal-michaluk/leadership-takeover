Feature: Unplanned leadership takeover

  Domain example:
  Efektor traci dowódcę. Szuka dowódcy wg planu.

  # Jak szukać kroków scenariuszy kożystając z Event Stormingu:
  # Given - pomarańczowe które zaszły wcześniej
  # When - niebieskie lub różowe karteczki
  # Then - pomarańczowe karteczki

  # przykład kompletnego scenariusza z perspektywy 2 aktorów
  Scenario: 1. Unplanned leadership takeover

    # Subordinate
    Given Subordinate notes lost Superior
    When Subordinate operator confirmed No Superior Warning
    Then change superior state [in Subordinate]
    Then No Superior Report is sent in Status

    # Interested C2Unit
    Given according to plan C2 unit should takeover leadership
    When C2 unit received No Superior Report
    Then C2 is interested to takeover leadership
    Then question about readiness to takeover leadership is shown for operator

    # Interested C2Unit   zgłosił
    When operator C2 unit confirm Readiness To Takeover Leadership
    Then Readiness To Takeover Leadership report is sent to Subordinate

    # Subordinate
    Given List of other available superiors
      | object | decision              |
      | C2_1   | not responded         |
      | C2_2   | will take superiority |
      | C2_5   | will take superiority |
    When Subordinate received Readiness To Takeover Leadership report
    Then C2 unit is added to Priority List of available superiors
    Then Priority List of available superiors is correctly sorted
      | object | decision              |
      | C2     | will take superiority |
      | C2_2   | will take superiority |
      | C2_5   | will take superiority |
    And Priority List of available superiors is shown for Subordinate operator

    # Subordinate
    When Subordinate operator selected New Superior from Priority List of available superiors
    Then selected C2 unit is set as New Superior
    And Status with New Superior is sent
    //And New Superior is marked on map [on Subordinate]


    # New Superior
    When C2 unit received new status with it as superior
    Then New Subordinate is added to Subordinate List [on New Superior]
    And Subordinate List with New Subordinate is shown for operator
    //And New Subordinate is marked on map [on New Superior]





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


