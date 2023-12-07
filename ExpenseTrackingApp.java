import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    private String description;
    private double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}

class ExpenseTracker {
    private ArrayList<Expense> expenses;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        System.out.println();
        System.out.println("Expense added successfully!");
    }

    public void displayExpenses() {
        System.out.println("Expense List:");
        System.out.println();
        for (Expense expense : expenses) {
            System.out.println("Description: " + expense.getDescription() + ", Amount: $" + expense.getAmount());
        }
    }

    public double calculateTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }
}

public class ExpenseTrackingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseTracker expenseTracker = new ExpenseTracker();

        while (true) {
            System.out.println();
            System.out.println("Expense Tracking Application");
            System.out.println("1. Add Expense");
            System.out.println("2. Display Expenses");
            System.out.println("3. Calculate Total Expenses");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter expense description: ");
                    String description = scanner.next();
                    System.out.print("Enter expense amount: $");
                    double amount = scanner.nextDouble();
                    Expense expense = new Expense(description, amount);
                    expenseTracker.addExpense(expense);
                    break;
                case 2:
                    System.out.println();
                    expenseTracker.displayExpenses();
                    break;
                case 3:
                    System.out.println();
                    double totalExpenses = expenseTracker.calculateTotalExpenses();
                    System.out.println("Total Expenses: $" + totalExpenses);
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
