import java.util.Scanner;

abstract public class ATM {
    float balance;
    int pin;
    Scanner input = new Scanner(System.in);

    ATM(int pin) {
        this.pin = pin;
        start();
    }

    ATM(int pin, float balance){
        this.pin = pin;
        this.balance = balance;
        start();
    }

    private void start(){
        System.out.println("\t\t->ATM<-");
        System.out.print("Enter pin: ");
        int n = input.nextInt();
        if(n == pin)
            menu();
        else
            System.out.println("Enter a valid pin.");
    }

    void menu() {
        int choice;
        do {
            System.out.println("Enter your choice: ");
            System.out.println("1. Check A/C Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void checkBalance() {
        System.out.println("Your account balance is: " + balance + "\n");
    }

    private void deposit() {
        int depositChoice;

        do {
            System.out.println("Enter your choice: ");
            System.out.println("1. Deposit Money");
            System.out.println("2. Back");
            depositChoice = input.nextInt();

            switch (depositChoice) {
                case 1:
                    System.out.print("Enter the amount: ");
                    int amount = input.nextInt();
                    if (amount <= 0)
                        System.out.println("\nInvalid Amount.");
                    else {
                        balance += amount;
                        System.out.println("\nMoney deposited successfully.");
                        checkBalance();
                    }
                    depositChoice = 2;
                    break;

                case 2:
                    break;
            }
        } while (depositChoice != 2);
    }

    private void withdraw() {
        int withdrawChoice;
        do {
            System.out.println("Enter your choice: ");
            System.out.println("1. Withdraw Money");
            System.out.println("2. Back");
            withdrawChoice = input.nextInt();

            switch (withdrawChoice) {
                case 1:
                    System.out.print("Enter the amount of money you want to withdraw: ");
                    int amount = input.nextInt();
                    if (amount > balance) {
                        System.out.println("\nInsufficient account balance.");
                    } else {
                        balance -= amount;
                        System.out.println("\nCash withdrawn.");
                        checkBalance();
                    }
                    withdrawChoice = 2;
                    break;

                case 2:
                    break;
            }
        }while (withdrawChoice != 2);
    }
}