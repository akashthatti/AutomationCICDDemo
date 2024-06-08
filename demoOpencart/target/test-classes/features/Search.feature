Feature: Searching the product

Scenario: Validate searching with an existing product name

Given users is on the landing page
When user enters the existing product name and clicks on search
Then product should be displayed

Scenario: Validate searching with an non existing product name

Given users is on the landing page
When user enters the non existing product name and clicks on search
Then There is no product that matches the search criteria. message should be displayed

Scenario: validate search by selecting catagory of the product

Given users is on the landing page
When user doesnt enter anything on search field and click on search button
And searches using search criteria search box and selects correct option in cateogory dropdown
Then product should be successfully displayed

Scenario: Validate navigating to product compare page from search results page

Given users is on the landing page
When user enters the existing product name and clicks on search
Then clicks on compare product option and user should be navigated to product compare page

Scenario: Validate adding the product to cart from product display page

Given users is on the landing page
When user enters the existing product name and clicks on search