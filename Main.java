import java.util.Scanner;

class Budget {
    String name;
    double income;
    double rent;
    double food;
    double transportation;
    double carPayment;
    double creditCardPayment;
    double savings;
    double totalBills;
    double totalExpenses;
    double moneyLeft;

    public void calculateBudget() {
        totalExpenses = rent + food + transportation + carPayment + creditCardPayment + totalBills + savings;
        moneyLeft = income - totalExpenses;
    }

    public void displaySummary() {
        System.out.println();
        System.out.println("Budget Summary for " + name.toUpperCase());
        System.out.println("--------------------------------");
        System.out.println("Monthly income: $" + income);
        System.out.println("Rent/Housing: $" + rent);
        System.out.println("Food: $" + food);
        System.out.println("Transportation: $" + transportation);
        System.out.println("Car payment: $" + carPayment);
        System.out.println("Credit card payment: $" + creditCardPayment);
        System.out.println("Total bills: $" + totalBills);
        System.out.println("Savings: $" + savings);
        System.out.println("Total expenses including savings: $" + totalExpenses);
        System.out.println("Money left after expenses: $" + moneyLeft);
    }

    public void displayBudgetStatus() {
        if (moneyLeft < 0) {
            System.out.println("Warning: Your expenses are higher than your income.");
        }

        if (moneyLeft >= 500) {
            System.out.println("Budget Status: Great job! You have a strong amount of money left over.");
        } else if (moneyLeft >= 100) {
            System.out.println("Budget Status: You have some money left, but you may want to watch your spending.");
        } else if (moneyLeft >= 0) {
            System.out.println("Budget Status: You are close to spending your full income.");
        } else {
            System.out.println("Budget Status: You may need to lower some expenses or reduce savings for this month.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Budget userBudget = new Budget();

        double billAmount;
        int numberOfBills;

        System.out.println("Welcome to the Monthly Budget Tracker!");

        System.out.print("Enter your name: ");
        userBudget.name = input.nextLine();

        System.out.print("Enter your monthly income: $");
        userBudget.income = input.nextDouble();

        System.out.print("Enter your rent/housing cost: $");
        userBudget.rent = input.nextDouble();

        System.out.print("Enter your monthly food cost: $");
        userBudget.food = input.nextDouble();

        System.out.print("Enter your transportation cost: $");
        userBudget.transportation = input.nextDouble();

        System.out.print("Enter your monthly car payment: $");
        userBudget.carPayment = input.nextDouble();

        System.out.print("Enter your monthly credit card payment: $");
        userBudget.creditCardPayment = input.nextDouble();

        System.out.print("Enter how many monthly bills you want to add, such as internet, water, or power: ");
        numberOfBills = input.nextInt();

        for (int i = 1; i <= numberOfBills; i++) {
            System.out.print("Enter bill #" + i + " amount: $");
            billAmount = input.nextDouble();
            userBudget.totalBills = userBudget.totalBills + billAmount;
        }

        System.out.print("Enter how much money you want to put into savings: $");
        userBudget.savings = input.nextDouble();

        userBudget.calculateBudget();
        userBudget.displaySummary();
        userBudget.displayBudgetStatus();

        input.close();
    }
}