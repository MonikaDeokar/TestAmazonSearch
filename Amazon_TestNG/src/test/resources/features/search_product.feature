Feature: User search an item
@Launch2
Scenario Outline: User performs searching an valid item in the application
Given the user is on search option
When the user enters the "<valid search>" and click submit button
Then the system displays item is available

Examples:
| valid search |
| Computers & Accessories |


@Launch3
Scenario Outline: User performs searching an invalid item in the application
Given the user in the search option for invalid search
When the user enters the "<SheetName>",<RowNumber> and click on submit button
Then the system displays item is not available

Examples:
| SheetName | RowNumber |
| Sheet1 | 0 |
