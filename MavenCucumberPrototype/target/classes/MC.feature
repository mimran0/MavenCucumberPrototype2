Feature: Mortgage Calculator

  Scenario Outline: Users are able to calculate mortgate payment in Mortgage Calculator website. -Google Chrome Browser
    Given Open Browser MC - "CHROME"
    Then Enter <vhomevalue> <vprincipal> <vinterestRate> <vterm> <vpropertyTax> <vpmi> <vhoi> in the calculator and click on calculate button
    And Check <vExpectedPayment> with Actual Payment

    Examples: 
      | vhomevalue | vprincipal | vinterestRate | vterm | vpropertyTax | vpmi   | vhoi   | vExpectedPayment |
      | "200000"   | "100000"   | "4"           | "30"  | "4.5"        | "1.26" | "1500" | "$1,352.42"      |
      | "200000"   | "100000"   | "5"           | "15"  | "4.7"        | "1.26" | "1500" | "$1,699.13"      |
      | "200000"   | "100000"   | "3"           | "10"  | "4.0"        | "1.26" | "1500" | "$1,757.27"      |
