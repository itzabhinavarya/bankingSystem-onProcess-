import java.util.Scanner;

public class mainBank{


    public static void createAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Name : ");
        String name = sc.nextLine();
        System.out.print("Create Id : ");
        String id = sc.nextLine();
        System.out.print("Create Password : ");
        String pwd = sc.nextLine();
    }
    public static void login(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Id : ");
        String id = sc.nextLine();
        System.out.print("Enter Your Password : ");
        String pwd = sc.nextLine();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Banking Console App");
        System.out.println("1 . Create Account \t 2 . Login");
        System.out.print("Enter Your Choice : ");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                createAccount();
                System.out.println("Account Created Successfully........");
                break;
            case 2:
                login();
                System.out.println("Logged in Successfully......");
                menuFunction mf = new menuFunction("","",0);
                mf.menus();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }


    }
}

class menuFunction{
    String name;
    String accountNumber;
    double balance;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    menuFunction(){
        System.out.println("Default constructor");
    }

    public menuFunction(String name, String accountNumber, double balance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount){
        this.balance+=amount;
        System.out.println("Rs "+amount+" Deposited in your account successfully");
        System.out.println("Current Balance is : Rs "+this.balance);
    }


    public void menus(){
        Scanner sc = new Scanner(System.in);


        System.out.println("Welcome To ApnaBank");
        System.out.println("1 . Deposit \t 2 . Withdraw");
        System.out.println("3 . Transfer \t 4 . Exit");
        System.out.print("Enter Your Choice : ");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                menuFunction mf;
                sc.nextLine();
                System.out.print("Enter Your Name : ");
                this.name = sc.nextLine();
                System.out.print("Enter Your AccountNumber : ");
                this.accountNumber = sc.nextLine();
                mf = new menuFunction(name,accountNumber,0);
                System.out.print("Enter Deposit amount : ");
                double amount = sc.nextDouble();
                mf.deposit(amount);
                break;
            case 2:
//                withdraw();
                System.out.println("withdraw()");
                break;
            case 3:
//                transfer();
                System.out.println("Transfer()");
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }

}
