import java.util.Scanner; // use Scanner for user input

public class Main {
   public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name;
        double income;
        double rent;
        double food;
        double transportation;
        double entertainment;
        double totalExpenses;
        double moneyLeft;
        int numberOfCategories = 4;

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

        System.out.print("Enter your entertainment or extra spending cost: $");
        entertainment = input.nextDouble();

        totalExpenses = rent + food + transportation + entertainment;
        moneyLeft = income - totalExpenses;

        System.out.println();
        System.out.println("Budget Summary for " + name.toUpperCase());
        System.out.println("--------------------------------");
        System.out.println("Number of expense categories: " + numberOfCategories);
        System.out.println("Monthly income: $" + income);
        System.out.println("Total expenses: $" + totalExpenses);
        System.out.println("Money left after expenses: $" + moneyLeft);

        input.close();
    }
}
