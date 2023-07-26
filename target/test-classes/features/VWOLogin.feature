Feature: Login to VWO Application

  Background:
    Given User is on Login page "https://app.vwo.com/"

  @ValidCredentials
  Scenario Outline: Login with valid credentials

    When User enters username as "<username>" and password as "<password>"
    Then User should be able to login sucessfully and new page "<new_title>"

    Examples:
      | username             | password    | new_title |
      | 93npu2yyb0@esiix.com | Wingify@123 | Dashboard |

  @InvalidCredentials
  Scenario Outline: Login with invalid credentials

    When User enters username as "<username>" and password as "<password>"
    Then User should be able to see error message "<errorMessage>"

    Examples:
      | username            | password  | errorMessage                                               |
      | 93npu2yyb0@esiix.co | admin12$$ | Your email, password, IP address or location did not match |
      | admin               | admin     | Your email, password, IP address or location did not match |
      | abc123              | xyz$$     | Your email, password, IP address or location did not match |