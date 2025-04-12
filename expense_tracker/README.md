# hw1- Manual Review

The homework will be based on this project named "Expense Tracker",where users will be able to add/remove daily transaction. 

The Expense Tracker application allows users to add, remove, and filter daily transactions. It follows the MVC architecture pattern and includes functionality for input validation and filtering transactions by amount or category.

## Features

1. **Add Transactions**:
   - Users can add transactions with a specified amount and category.
   - Input validation ensures that only valid amounts and categories are accepted.

2. **Remove Transactions**:
   - Users can remove transactions from the list.
   - **Note**: The `removeTransaction` functionality is implemented but has not yet been integrated into the Expense Tracker application UI.

3. **Filter Transactions**:
   - Filter transactions by amount.
   - Filter transactions by category.
   - **Input Validation for Filters**:
     - Ensures that the amount entered for filtering is valid (e.g., positive and within a valid range 0-1000).
     - Ensures that the category entered for filtering is valid and predefined (e.g., "food", "travel", "bills", "entertainment", "other").

4. **Input Validation**:
   - Ensures that amounts are positive and within a valid range ( 0-1000 ).
   - Ensures that categories are valid and predefined (e.g., "food", "travel", "bills", "entertainment", "other").
   - Input validation is also applied to filtering transactions.

5. **Total Cost Calculation**:
   - Automatically calculates and displays the total cost of all transactions.

6. **Unit Tests**:
   - Comprehensive unit tests for adding, removing, and filtering transactions, as well as handling invalid inputs.

## Compile

To compile the code and place the `.class` files in the `bin` folder, use the following commands:
```
cd src
javac -d ../bin model/*.java controller/*.java view/*.java ExpenseTrackerApp.java
```

## Run

To run the application from the `bin` folder, use the following commands:
```
cd ../bin
java ExpenseTrackerApp
```

## Compile

To compile the code from terminal, use the following command:
```
cd src
javac ExpenseTrackerApp.java
java ExpenseTracker
```

You should be able to view the GUI of the project upon successful compilation. 

## Java Version
This code is compiled with ```openjdk 17.0.7 2023-04-18```. Please update your JDK accordingly if you face any incompatibility issue.