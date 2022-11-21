Feature: To Test Card Effects

  @foxhole
  Scenario Outline: Hover over cards and click on the hyperlink
    Given user navigates to FoxHole Homepage
    When user clicks on the "Services" above from the menu
    Then user hovers over the cards and validates effects
    And user validates show more button color
    When user clicks on the "Gallery" above from the menu
    And user hovers over red banner
    Then user should see the red banner expand with the link
    When user clicks on the link on red banner
    Then user should land on the '<titleName>' sign in page


    Examples:
      | titleName             |
      | Google Forms: Sign-in |



