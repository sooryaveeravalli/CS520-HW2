# CS520 - Homework 2: Expense Tracker Application

## Overview

This repository contains Homework 2 for CS520 (Software Engineering), which implements an **Expense Tracker Application** demonstrating key software engineering concepts and design patterns.

## Project Description

The Expense Tracker is a Java-based desktop application that allows users to manage daily financial transactions. The application follows the **Model-View-Controller (MVC)** architecture pattern and incorporates several software engineering principles and design patterns.

## Key Features

### Core Functionality
- **Add Transactions**: Add new transactions with amount and category
- **Remove Transactions**: Remove existing transactions from the list
- **Filter Transactions**: Filter by amount or category using strategy pattern
- **Total Cost Calculation**: Automatic calculation of total expenses
- **Input Validation**: Comprehensive validation for amounts and categories

### Software Engineering Concepts Demonstrated

1. **MVC Architecture Pattern**
   - **Model**: Handles data and business logic (`ExpenseTrackerModel`)
   - **View**: Manages user interface (`ExpenseTrackerView`)
   - **Controller**: Coordinates between model and view (`ExpenseTrackerController`)

2. **Design Patterns**
   - **Strategy Pattern**: Implemented for transaction filtering (`AmountFilter`, `CategoryFilter`)
   - **Open-Closed Principle**: Extensible filtering system without modifying existing code

3. **Input Validation**
   - Amount validation (positive values, range 0-1000)
   - Category validation (predefined categories: food, travel, bills, entertainment, other)

4. **Comprehensive Testing**
   - Unit tests for all major functionality
   - Test coverage for edge cases and invalid inputs
   - JUnit framework integration

## Project Structure

```
expense_tracker/
├── src/
│   ├── model/          # Data models and business logic
│   ├── view/           # User interface components
│   ├── controller/     # Application logic and validation
│   └── ExpenseTrackerApp.java  # Main application entry point
├── test/               # Unit test files
├── bin/                # Compiled class files
├── lib/                # External dependencies (JUnit)
├── jdoc/               # Generated JavaDoc documentation
├── build.xml           # Ant build configuration
└── README.md           # Detailed project documentation
```

## Technologies Used

- **Java 17** (OpenJDK 17.0.7)
- **JUnit 4.11** for unit testing
- **Apache Ant** for build automation
- **JavaDoc** for documentation generation

## Setup and Installation

### Prerequisites
- Java JDK 17 or higher
- Apache Ant (optional, for build automation)

### Compilation

**Option 1: Manual Compilation**
```bash
cd expense_tracker/src
javac -d ../bin model/*.java controller/*.java view/*.java ExpenseTrackerApp.java
```

**Option 2: Using Ant (Recommended)**
```bash
cd expense_tracker
ant compile
```

### Running the Application

**Option 1: Direct Execution**
```bash
cd expense_tracker/bin
java ExpenseTrackerApp
```

**Option 2: Using Ant**
```bash
cd expense_tracker
ant run
```

### Running Tests

```bash
cd expense_tracker
ant test
```

### Generating Documentation

```bash
cd expense_tracker
ant document
```

## Testing

The project includes comprehensive unit tests covering:

- Transaction addition and removal
- Input validation (amount and category)
- Filtering functionality (amount and category filters)
- Edge cases and error handling
- Total cost calculations

Run tests using:
```bash
cd expense_tracker
ant test
```

## Documentation

JavaDoc documentation is available in the `jdoc/` directory. Generate updated documentation using:
```bash
cd expense_tracker
ant document
```

## Git History

The project demonstrates proper version control practices with meaningful commit messages documenting the implementation of various features:

- MVC architecture implementation
- Strategy pattern for filtering
- Open-closed principle implementation
- Comprehensive testing suite
- Documentation generation

## Author

**Sai Soorya Rao Veeravalli**
- Course: CS520 - Software Engineering
- Assignment: Homework 2 - Manual Review

## License

This project is created for educational purposes as part of the CS520 Software Engineering course.