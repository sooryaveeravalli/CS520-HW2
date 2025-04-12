// package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import controller.AmountFilter;
import controller.CategoryFilter;
import controller.TransactionFilter;
import controller.ExpenseTrackerController;
import model.ExpenseTrackerModel;
import model.Transaction;
import view.ExpenseTrackerView;


public class TestExample {
  
  private ExpenseTrackerModel model;
  private ExpenseTrackerView view;
  private ExpenseTrackerController controller;

  @Before
  public void setup() {
    model = new ExpenseTrackerModel();
    view = new ExpenseTrackerView();
    controller = new ExpenseTrackerController(model, view);
  }

    public double getTotalCost() {
        double totalCost = 0.0;
        List<Transaction> allTransactions = model.getTransactions(); // Using the model's getTransactions method
        for (Transaction transaction : allTransactions) {
            totalCost += transaction.getAmount();
        }
        return totalCost;
    }
    


    @Test
    public void testAddTransaction() {
        // Pre-condition: List of transactions is empty
        assertEquals(0, model.getTransactions().size());
    
        // Perform the action: Add a transaction
        assertTrue(controller.addTransaction(50.00, "food"));
    
        // Post-condition: List of transactions contains one transaction
        assertEquals(1, model.getTransactions().size());
    
        // Check the contents of the list
        assertEquals(50.00, getTotalCost(), 0.01);
    }


    @Test
    public void testRemoveTransaction() {
        // Pre-condition: List of transactions is empty
        assertEquals(0, model.getTransactions().size());
    
        // Perform the action: Add and remove a transaction
        Transaction addedTransaction = new Transaction(50.00, "Groceries");
        model.addTransaction(addedTransaction);
    
        // Pre-condition: List of transactions contains one transaction
        assertEquals(1, model.getTransactions().size());
    
        // Perform the action: Remove the transaction
        model.removeTransaction(addedTransaction);
    
        // Post-condition: List of transactions is empty
        List<Transaction> transactions = model.getTransactions();
        assertEquals(0, transactions.size());
    
        // Check the total cost after removing the transaction
        double totalCost = getTotalCost();
        assertEquals(0.00, totalCost, 0.01);
    }

    @Test
    public void testAddTransactionWithDifferentExample() {
        // Pre-condition: List of transactions is empty
        assertEquals(0, model.getTransactions().size());

        // Perform the action: Add a transaction with amount 75.00 and category "travel"
        assertTrue(controller.addTransaction(75.00, "travel"));

        // Post-condition: List of transactions contains one transaction
        assertEquals(1, model.getTransactions().size());

        // Check the contents of the list
        Transaction addedTransaction = model.getTransactions().get(0);
        assertEquals(75.00, addedTransaction.getAmount(), 0.01);
        assertEquals("travel", addedTransaction.getCategory());

        // Check the total cost
        assertEquals(75.00, getTotalCost(), 0.01);
    }

    @Test
    public void testInvalidInputHandling() {
        // Pre-condition: List of transactions is empty
        assertEquals(0, model.getTransactions().size());

        // Attempt to add invalid transactions
        assertTrue(!controller.addTransaction(-10.00, "food")); // Invalid amount
        assertTrue(!controller.addTransaction(50.00, "invalidCategory")); // Invalid category

        // Post-condition: List of transactions remains empty
        assertEquals(0, model.getTransactions().size());

        // Total cost remains unchanged
        assertEquals(0.00, getTotalCost(), 0.01);
    }

    @Test
    public void testFilterByAmount() {
        // Pre-condition: List of transactions is empty
        assertEquals(0, model.getTransactions().size());

        // Add multiple transactions
        controller.addTransaction(50.00, "food");
        controller.addTransaction(100.00, "travel");
        controller.addTransaction(50.00, "bills");

        // Apply filter by amount
        AmountFilter filter = new AmountFilter(50.00);
        List<Transaction> filteredTransactions = filter.filter(model.getTransactions());

        // Expected: Only transactions with amount 50.00 are returned
        assertEquals(2, filteredTransactions.size());
        for (Transaction t : filteredTransactions) {
            assertEquals(50.00, t.getAmount(), 0.01);
        }
    }
    
    @Test
    public void testFilterByCategory() {
        // Pre-condition: List of transactions is empty
        assertEquals(0, model.getTransactions().size());

        // Add multiple transactions
        controller.addTransaction(50.00, "food");
        controller.addTransaction(100.00, "travel");
        controller.addTransaction(50.00, "food");

        // Apply filter by category
        CategoryFilter filter = new CategoryFilter("food");
        List<Transaction> filteredTransactions = filter.filter(model.getTransactions());

        // Expected: Only transactions with category "food" are returned
        assertEquals(2, filteredTransactions.size());
        for (Transaction t : filteredTransactions) {
            assertEquals("food", t.getCategory());
        }
    }
}