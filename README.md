# DiscountCalculator

Code Explanation:

Customer.java
Represents a customer with attributes like name, card type, years, and a list of associated items.
Provides methods to manipulate customer data such as adding items and retrieving item lists.

Card.java
Represents different types of cards that customers can possess, like golden, silver, affiliate, or no card at all.

Item.java
Represents items that customers can purchase, so the objects of this class can be food, phones, or books.
This class contains attributes like name, price, and a flag (a boolena value) to indicate if the item is a phone or not.

DiscountCalculator.java
Contains logic to calculate discounts based on customer card types, item purchases, and additional discount rules.
This java class provides methods to calculate the total price for a customer and display items associated with a customer.

Constants.java
Contains constants used in the project, such as card types, item names, prices, and discount percentages.
Centralizes these values for easy access and modification.

CustomerTest.java
A JUnit test class to validate the functionality of the Customer class.
Includes test cases to check if the customer creation and item association work as expected.



Additional Notes
Ensure that the necessary dependencies are downloaded by Maven before executing any commands.
Modify the input data or expand the test cases in CustomerTest.java to further validate the application's behavior.
