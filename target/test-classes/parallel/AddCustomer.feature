Feature: Add Customer Feature

Scenario Outline: Add Custmer with different set of data
Given user navigate to add customer page
When user fills the form from given sheetname "<SheetName>" and rownumber <RowNumber>
And user clicks on send button
Then it shows a successful message "Please Note Down Your CustomerID"

Examples:
|SheetName|RowNumber|
|addcustomer|0|
|addcustomer|1|

