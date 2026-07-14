import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.*;

class BudgetCategory {
    String categoryName;
    double amount;

    public BudgetCategory(String categoryName, double amount) {
        this.categoryName = categoryName;
        this.amount = amount;
    }
}

class Budget {
    String name;
    double income;
    ArrayList<BudgetCategory> categories;

    public Budget(String name, double income) {
        this.name = name;
        this.income = income;
        this.categories = new ArrayList<BudgetCategory>();
    }

    public void addCategory(String categoryName, double amount) {
        categories.add(new BudgetCategory(categoryName, amount));
    }

    public double calculateTotalExpenses() {
        double total = 0;

        for (BudgetCategory category : categories) {
            total = total + category.amount;
        }

        return total;
    }

    public double calculateMoneyLeft() {
        return income - calculateTotalExpenses();
    }

    public void displaySummary() {
        DecimalFormat moneyFormat = new DecimalFormat("0.00");

        double totalExpenses = calculateTotalExpenses();
        double moneyLeft = calculateMoneyLeft();

        System.out.println();
        System.out.println("Budget Summary for " + name.toUpperCase());
        System.out.println("--------------------------------");
        System.out.println("Monthly Income: $" + moneyFormat.format(income));

        System.out.println();
        System.out.println("Budget Categories:");

        for (BudgetCategory category : categories) {
            System.out.println(category.categoryName + ": $" + moneyFormat.format(category.amount));
        }

        System.out.println();
        System.out.println("Total Expenses and Savings: $" + moneyFormat.format(totalExpenses));
        System.out.println("Money Left After Expenses and Savings: $" + moneyFormat.format(moneyLeft));
    }

    public void displayBudgetStatus() {
        double moneyLeft = calculateMoneyLeft();

        if (moneyLeft < 0) {
            System.out.println("Warning: Your expenses are higher than your income.");
        }

        if (moneyLeft >= 500) {
            System.out.println("Budget Status: Great job! You have over $500 left for the month.");
        } else if (moneyLeft >= 100) {
            System.out.println("Budget Status: You have over $100 left for the month.");
        } else if (moneyLeft >= 0) {
            System.out.println("Budget Status: You are close to spending your full income.");
        } else {
            System.out.println("Budget Status: You may need to lower some expenses or reduce savings for this month.");
        }
    }
}

class PieChartPanel extends JPanel {
    ArrayList<BudgetCategory> categories;

    public PieChartPanel(ArrayList<BudgetCategory> categories) {
        this.categories = categories;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        double total = 0;

        for (BudgetCategory category : categories) {
            total = total + category.amount;
        }

        if (total <= 0) {
            g.drawString("No budget data to display.", 50, 50);
            return;
        }

        int x = 50;
        int y = 50;
        int width = 300;
        int height = 300;
        int startAngle = 0;

        Color[] colors = {
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.ORANGE,
            Color.MAGENTA,
            Color.CYAN,
            Color.PINK,
            Color.YELLOW,
            Color.LIGHT_GRAY,
            Color.GRAY
        };

        DecimalFormat percentFormat = new DecimalFormat("0.0");

        for (int i = 0; i < categories.size(); i++) {
            BudgetCategory category = categories.get(i);

            int arcAngle = (int) Math.round((category.amount / total) * 360);

            g.setColor(colors[i % colors.length]);
            g.fillArc(x, y, width, height, startAngle, arcAngle);

            startAngle = startAngle + arcAngle;
        }

        int legendX = 400;
        int legendY = 70;

        g.setColor(Color.BLACK);
        g.drawString("Budget Category Percentages", legendX, 40);

        for (int i = 0; i < categories.size(); i++) {
            BudgetCategory category = categories.get(i);
            double percentage = (category.amount / total) * 100;

            g.setColor(colors[i % colors.length]);
            g.fillRect(legendX, legendY + (i * 25), 15, 15);

            g.setColor(Color.BLACK);
            g.drawString(
                category.categoryName + " - " + percentFormat.format(percentage) + "%",
                legendX + 25,
                legendY + 12 + (i * 25)
            );
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name;
        double income;
        double rent;
        double food;
        double transportation;
        double carPayment;
        double creditCardPayment;
        double savings;
        double billAmount;
        String billName;
        int numberOfBills;

        System.out.println("Welcome to the Monthly Budget Tracker!");

        System.out.print("Enter your name: ");
        name = input.nextLine();

        System.out.print("Enter your monthly income: $");
        income = input.nextDouble();

        Budget userBudget = new Budget(name, income);

        System.out.print("Enter your rent or housing cost: $");
        rent = input.nextDouble();
        userBudget.addCategory("Rent/Housing", rent);

        System.out.print("Enter your monthly food cost: $");
        food = input.nextDouble();
        userBudget.addCategory("Food", food);

        System.out.print("Enter your transportation cost: $");
        transportation = input.nextDouble();
        userBudget.addCategory("Transportation", transportation);

        System.out.print("Enter your monthly car payment: $");
        carPayment = input.nextDouble();
        userBudget.addCategory("Car Payment", carPayment);

        System.out.print("Enter your monthly credit card payment: $");
        creditCardPayment = input.nextDouble();
        userBudget.addCategory("Credit Card Payment", creditCardPayment);

        System.out.print("Enter how much money you want to put into savings: $");
        savings = input.nextDouble();
        userBudget.addCategory("Savings", savings);

        System.out.print("Enter how many monthly bills you want to add, such as internet, water, or power: ");
        numberOfBills = input.nextInt();
        input.nextLine();

        for (int i = 1; i <= numberOfBills; i++) {
            System.out.print("Enter the name of bill #" + i + ": ");
            billName = input.nextLine();

            System.out.print("Enter the amount for " + billName + ": $");
            billAmount = input.nextDouble();
            input.nextLine();

            userBudget.addCategory(billName, billAmount);
        }

        userBudget.displaySummary();
        userBudget.displayBudgetStatus();

        JFrame frame = new JFrame("Budget Pie Chart");
        PieChartPanel chartPanel = new PieChartPanel(userBudget.categories);

        frame.add(chartPanel);
        frame.setSize(700, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        input.close();
    }
}