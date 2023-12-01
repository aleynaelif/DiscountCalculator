# DiscountCalculator

This is a java program for a website that has customers, items to sell and different types of cards for discounts. The program calculates the discount percentages 
for users that have or doesn't have a store card. 

Discount rules are as following:

1. If user has a gold card, he/she gets %30 discount
2. If user has a silver card, he/she gets %20 discount
3. If  user is an affiliate of the store, he/she gets a %10 discount
4. If the user has been a customer for over 2 years, he/she gets a %5 discount. (Customer doesn't have to have a card for that condition)
5. For every $200 on the bill, there would be a $5 discount (Customer doesn't have to have a card for that condition)
6. The percentage based discounts do not apply on phones. (But $5 for $200 does)
7. A user can get only one of the percentage based discounts on a bill. (Affiliates doesn't get extra %10, they just get %10 discount)


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

Prerequisites:

Java 8 or higher installed
Maven installed

How to Run:

Clone the repository:
```
git clone <repository_url>
```

Navigate to the project directory:
```
cd retail-application
```

Compile the project:
```
mvn compile
```

Run the main application:
```
mvn exec:java -Dexec.mainClass="org.example.Main"
```

Running Tests
The project includes JUnit tests to verify the functionality of classes. To run the tests:
```
mvn test
```


Additional Notes:
Ensure that the necessary dependencies are downloaded by Maven before executing any commands.
Modify the input data or expand the test cases in CustomerTest.java to further validate the application's behavior.
