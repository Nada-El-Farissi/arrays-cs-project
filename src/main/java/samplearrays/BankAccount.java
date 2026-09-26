package samplearrays;

public class BankAccount {

    String name;
    static double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    static Double[] transactions=new Double[1000];
    static int transactionCount=0;//to know what index to modify in the transactions array

    public BankAccount(String name, int startingBalance){
            this.name=name;
            currentBalance=startingBalance;
    }

    public void deposit(double amount){
        if (amount<0){
            System.out.println("The deposit amount is invalid, please enter a positive amount");

        }

        else {
            currentBalance += amount;
            transactions[transactionCount] = amount;
            transactionCount++;
            System.out.println("name: " + name + " deposited amount: " + amount + " new balance: " + currentBalance);
        }
    }

    public void withdraw(double amount){
        if (amount>currentBalance){
            System.out.println("Withdrawal unsuccessful");
        }
        else {
        currentBalance-=amount;
        transactions[transactionCount]=(-amount);
        transactionCount++;}
    }

    public void displayTransactions(){
        for (int i=0;i<transactionCount;i++){
            System.out.println(transactions[i]);
        }
    }

    public void displayBalance(){
        System.out.println("Current balance: "+currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
