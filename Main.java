import java.util.Scanner;

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
        double totalBills = 0;
        double totalExpenses;
        double moneyLeft;
        int numberOfBills;

        System.out.println("Welcome to the Monthly Budget Tracker!");

        System.out.print("Enter your name: ");
        name = input.nextLine();

        System.out.print("Enter your monthly income: $");
        income = input.nextDouble();

        System.out.print("Enter your rent or housing cost: $");
        rent = input.nextDouble();

        System.out.print("Enter your monthly food cost: $");
        food = input.nextDouble();

        System.out.print("Enter your transportation cost: $");
        transportation = input.nextDouble();

        System.out.print("Enter your monthly car payment: $");
        carPayment = input.nextDouble();

        System.out.print("Enter your monthly credit card payment: $");
        creditCardPayment = input.nextDouble();

        System.out.print("Enter how many monthly bills you want to add, such as internet, water, or power: ");
        numberOfBills = input.nextInt();

        for (int i = 1; i <= numberOfBills; i++) {
            System.out.print("Enter bill #" + i + " amount: $");
            billAmount = input.nextDouble();
            totalBills = totalBills + billAmount;
        }

        System.out.print("Enter how much money you want to put into savings: $");
        savings = input.nextDouble();

        totalExpenses = rent + food + transportation + carPayment + creditCardPayment + totalBills + savings;
        moneyLeft = income - totalExpenses;

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

        // First if statement
        if (moneyLeft < 0) {
            System.out.println("Warning: Your expenses are higher than your income.");
        }

        // Second if statement with else if and else
        if (moneyLeft >= 500) {
            System.out.println("Budget Status: Great job! You have a over $500 left over.");
        } else if (moneyLeft >= 100) {
            System.out.println("Budget Status: You have over $100 left over.");
        } else if (moneyLeft >= 0) {
            System.out.println("Budget Status: You are close to spending your full income.");
        } else {
            System.out.println("Budget Status: You may need to lower some expenses or reduce savings for this month.");
        }

        input.close();
    }
}