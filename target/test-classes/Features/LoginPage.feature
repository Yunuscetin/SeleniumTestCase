#noinspection NonAsciiCharacters
Feature: N11.com login page scenarios

  Background:
    Given User navigate to n11.com
  @Login

  Scenario Outline: Check clickable of different input methods
    When Is the "<Input>" element clickable?
    Examples:
      |Input      |
      |Username   |
      |Password   |
      |LoginButton|
      |Apple      |
      |Hızlıgiris |
      |Facebook   |

    Scenario Outline: Check that the different input methods are oriented correctly
    When Is the "<Input>" oriented correctly?
    Examples:
      |Input      |
      |Apple      |
      |Hızlıgiris |
      |Facebook   |


  Scenario Outline: User should be not login, when username or password or both is empty
    When User enters "<Username>" and "<Password>"
    Then User should not be logged in

    Examples:
      | Username              | Password              |
      | yunusceetin@gmail.com |                       |
      |                       | asd                   |
      |                       |                       |

  Scenario Outline: User should be not login, when username contains invalid field
    When User enters "<Username>" and "<Password>"
    Then Error message is displayed for email

    Examples:
      | Username                 | Password |
      | yunusce   etin@gmail.com | asd1234  |
      | yunus+'^%&^@gmail.com    | asd1234  |
      | yunus.com                | asd1234  |
      | yunus@gmail              | asd1234  |

  Scenario Outline: User should be not login, when password contains invalid field
    When User enters "<Username>" and "<Password>"
    Then Error message is displayed for "<Password>"
    Examples:
      | Username            | Password               |
      | yunuscetin@gmail.com| asd12                  |
      | yunuscetin@gmail.com| asd123456789123456789  |

  Scenario Outline: User should be not login, when enters wrong username or password
    When User enters "<Username>" and "<Password>"
    Then User should not be logged in

    Examples:
      | Username               | Password|
      | yunusceetin@gmail.com  | adfg1231|
      | asdf@gmail.com         | Yunus123|
      | asff@gmail.com         | adfg1231|
