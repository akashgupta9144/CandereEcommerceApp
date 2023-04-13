@ui @healthcheck

Feature: E-commerce Project Application Health Check

Background: Navigation to the URL of the application
Given User navigate to the landing page URL of the Application

@validate_LP
Scenario: User can Open the browser and navigate to the URL of the E-commerce Application
And validate the landing page of the application

@searchProduct
Scenario: Search the product details
When User is searching the product "majestic solitaire diamond ring"

@selectProduct
Scenario: Select and validate the product details 
When User is searching the product "majestic solitaire diamond ring"
Then User click the selected product
And Validate the searching product details page of the application
And User select the size of the product is "18" 
And Validate the selected size of the product 

@footer_LP
Scenario: Validate the footer links of landing  Website page
When User Scroll Down the landing page of the application
Then validate options under the ABOUT US section of the landing page 
|About Our Company   |
|Terms and Conditions|
|Privacy Policy      |
|FAQ                 |
|Offers T&Cs         |
|Customer Reviews    |

@follow_Us
Scenario Outline: Validate the Follow_Us section option links
When User Scroll Down the landing page 
Then User select and validate the "<options>"
Examples:
|options  |
|facebook |
|instagram|
|twitter  |

