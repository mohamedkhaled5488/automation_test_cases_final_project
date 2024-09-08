@smoke
Feature: User could navigate to social networks (Facebook, Twitter, RSS, YouTube)

  Scenario: User could open Facebook link
    When  User scroll down and click on FacebookIcon
    Then  User should be directed to Facebook Website

  Scenario: User could open Twitter link
    When  User scroll down and click on TwitterIcon
    Then  User should be directed to Twitter Website

  Scenario: User could open RSS link
    When  User scroll down and click on RSSIcon
    Then  User should be directed to RSS Website

  Scenario: User could open YouTube link
    When  User scroll down and click on YouTubeIcon
    Then  User should be directed to YouTube Website

  Scenario Outline: User could navigate social networks
    When  User scroll down and click on "<Network>" icons
    Then  User redirected to social networks "<Links>"
    Examples:
      | Network  | Links                                   |
      | facebook | http://www.facebook.com/nopCommerce     |
      | twitter  | https://twitter.com/nopCommerce         |
      | rss      | /news/rss/1                             |
      | youtube  | http://www.youtube.com/user/nopCommerce |
