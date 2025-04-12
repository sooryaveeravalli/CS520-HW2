import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.ExpenseTrackerController;
import controller.TransactionFilter;
import controller.AmountFilter;
import controller.CategoryFilter;
import model.ExpenseTrackerModel;
import view.ExpenseTrackerView;
import model.Transaction;
import controller.InputValidation;

public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    ExpenseTrackerModel model = new ExpenseTrackerModel();
    ExpenseTrackerView view = new ExpenseTrackerView();
    ExpenseTrackerController controller = new ExpenseTrackerController(model, view);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      // Get transaction data from view
      double amount = view.getAmountField();
      String category = view.getCategoryField();
      
      // Call controller to add transaction
      boolean added = controller.addTransaction(amount, category);
      
      if (!added) {
        JOptionPane.showMessageDialog(view, "Invalid amount or category entered");
        view.toFront();
      }
    });

  // Handle filter by Amount button clicks
    view.getFilterByAmountBtn().addActionListener(e -> {
        // Get filter data from view
        double amount = view.getAmountField();
        if (!InputValidation.isValidAmount(amount)) {
            JOptionPane.showMessageDialog(view, "Invalid amount entered in filter");
            view.toFront();
            return;
        }
        controller.applyFilter(new AmountFilter(amount));
    });

    // Handle filter by Category button clicks
    view.getFilterByCategoryBtn().addActionListener(e -> {
        // Get filter data from view
        String category = view.getCategoryField();
        if (!InputValidation.isValidCategory(category)) {
            JOptionPane.showMessageDialog(view, "Invalid category entered in filter");
            view.toFront();
            return;
        }
        controller.applyFilter(new CategoryFilter(category));
    });

  }

}