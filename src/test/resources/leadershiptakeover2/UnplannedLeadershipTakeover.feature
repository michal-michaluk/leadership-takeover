Feature: Planned leadership takeover

  Domain example:
Efektor traci dowódcę. Szuka dowódcy wg planu.

  # Jak szukać kroków scenariuszy kożystając z Event Stormingu:
  # Given - pomarańczowe które zaszły wcześniej
  # When - niebieskie lub różowe karteczki
  # Then - pomarańczowe karteczki

  # przykład kompletnego scenariusza z perspektywy 2 aktorów
  Scenario: Unplanned leadership takeover

    # Subordinate
    When Subordinate notes no status from his Superior
    Then No Superior Warning is shown

    # Subordinate
    When Subordinate operator check No Superior Report
    Then No Superior Report is sent in Status

    # Any C2Unit
    When C2 unit received No Superior Report
    Then Check in Planed Superior List if should be interested to takeover leadership

    # Interested C2Unit
    When received No Superior Report is filtered
    Then question about readiness to takeover leadership is shown for operator

    # Interested C2Unit
    When operator C2 unit reported readiness to takeover leadership
    Then Readiness To Takeover Leadership report is sent to Subordinate

    # Subordinate
    When Subordinate received Readiness To Takeover Leadership report
    Then add C2 unit to Priority List of available superiors
    And show Priority List of available superiors for Subordinate operator

    # Subordinate
    When Subordinate operator selected New Superior from Priority List of available superiors
    Then set selected C2 unit as New Superior
    And New Superior is marked on map [on Subordinate]
    And send Status with New Superior

    # New Superior
    When C2 unit received new status with it as superior
    Then New Subordinate is added to Subordinate List [on New Superior]
    And New Subordinate is marked on map [on New Superior]





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


