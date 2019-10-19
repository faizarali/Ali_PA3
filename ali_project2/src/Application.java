public class Application {
    public static void main(String args[]) {
        int i = 1;
        int j = 1;

        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        SavingsAccount.modifyInterestRate(4);

        System.out.println("The Annual Interest Rate is 4%.");
        System.out.println("");

        System.out.println("Here is saver1's monthly interest for a year.");

        while(i <= 12) {
            saver1.calculateMonthlyInterest();

            if(i >= 10)
                System.out.print("Month " + i + ":  ");
            else
                System.out.print("Month " + i + ":   ");

            saver1.Current_Amount();

            System.out.println("");
            i++;
        }

        System.out.println("");
        System.out.println("Here is saver2's monthly interest for a year.");

        while(j <= 12) {
            saver2.calculateMonthlyInterest();

            if(j >= 10)
                System.out.print("Month " + j + ":  ");
            else
                System.out.print("Month " + j + ":   ");

            saver2.Current_Amount();

            System.out.println("");
            j++;
        }

        System.out.println("");
        System.out.println("The Annual Interest Rate is now 5%.");
        System.out.println("");

        SavingsAccount.modifyInterestRate(5);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("Here is saver1's New Balance for the next month.");
        System.out.print("-> ");
        saver1.Current_Amount();

        System.out.println("");
        System.out.println("");

        System.out.println("Here is saver2's New Balance for the next month.");
        System.out.print("-> ");
        saver2.Current_Amount();

    }
}

class SavingsAccount {
    private static double annualInterestRate = 0;
    private double savingsBalance = 0;

    SavingsAccount(double money) {
        savingsBalance = money;
    }

    public void calculateMonthlyInterest() {
        double amount = (savingsBalance * annualInterestRate) / 12;

        if(amount >= 0)
            savingsBalance = savingsBalance + amount;
    }

    public static void modifyInterestRate(double rate) {
        annualInterestRate = rate / 100;
    }

    void Current_Amount() {
        System.out.printf("$" + "%.2f", savingsBalance);
    }
}