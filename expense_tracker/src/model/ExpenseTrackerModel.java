package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ExpenseTrackerModel {

  // Adding encapsulation
  private final List<Transaction> transactions;

  public ExpenseTrackerModel() {
    transactions = new ArrayList<>(); 
  }

  public void addTransaction(Transaction t) {
    transactions.add(t);
  }

  public void removeTransaction(Transaction t) {
    transactions.remove(t);
  }

  public List<Transaction> getTransactions() {
    // Return an immutable copy of the transactions list
    return Collections.unmodifiableList(transactions);
  }

}