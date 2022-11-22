import java.util.Scanner;

public class mainBank {


    public static void createAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Name : ");
        String name = sc.nextLine();
        System.out.print("Create Id : ");
        String id = sc.nextLine();
        System.out.print("Create Password : ");
        String pwd = sc.nextLine();
    }

    public static void login() {
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
        switch (choice) {
            case 1:
                createAccount();
                System.out.println("Account Created Successfully........");
                break;
            case 2:
                login();
                System.out.println("Logged in Successfully......");
                menuFunction mf = new menuFunction("", "", 0, "");
                mf.menus();
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }
}

class menuFunction {
    String name;
    String accountNumber;
    double balance;

    String receiverAccountNumber;

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

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

    menuFunction() {
        System.out.println("Default constructor");
    }

    public menuFunction(String name, String accountNumber, double balance, String receiverAccountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Rs " + amount + " Deposited in your account successfully");
        System.out.println("Current Balance is : Rs " + this.balance);
    }

    boolean flag = false;

    public void withdraw(double amount) {
        if (this.balance >= 0) {
            if (amount <= this.balance) {
                this.balance -= amount;
                System.out.println("Rs" + amount + " Withdraw Successfully......");
            } else {
                System.out.println("Only " + "Rs." + this.balance + " Can be Withdraw");
                flag = true;
            }
        } else {
            System.out.println("Insufficient Fund In Your Account");
        }
    }

    public void transfer(double amount, String receiverAccountNumber) {
        if (this.balance >= 0) {
            if (amount <= this.balance) {
                this.balance -= amount;
                // addition code in Transferred account
                System.out.println("Rs" + amount + " Transferred Successfully in " + receiverAccountNumber + " Account");
            } else {
                System.out.println("Only " + "Rs." + this.balance + " Can be Transferred");
            }
        } else {
            System.out.println("Insufficient Fund In Your Account");
        }
    }

    public void checkBalance() {
        System.out.println("The Available Balance in your account is Rs" + this.balance);
    }

    public void menus() {

        Scanner sc = new Scanner(System.in);
        menuFunction mf;
        mf = new menuFunction(name, accountNumber, this.balance, this.receiverAccountNumber);

        while (true) {
            System.out.println("Welcome To ApnaBank");
            System.out.println("1 . Deposit \t 2 . Withdraw");
            System.out.println("3 . Transfer \t 4 . Check Balance \t 5 . Exit");
            System.out.print("Enter Your Choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Your Name : ");
                    this.name = sc.nextLine();
                    System.out.print("Enter Your AccountNumber : ");
                    this.accountNumber = sc.nextLine();
                    System.out.print("Enter Deposit amount : ");
                    double amount = sc.nextDouble();
                    mf.deposit(amount);
                    while (true) {
                        char ch;
                        System.out.print("Do you want to add more fund ?(Y/N) : ");
                        ch = sc.next().charAt(0);
                        if (ch == 'Y' || ch == 'y') {
                            System.out.print("Enter Deposit amount : ");
                            amount = sc.nextDouble();
                            mf.deposit(amount);
                        } else {
                            break;
                        }
                    }
                    break;
                case 2:
                    sc.nextLine();
                    System.out.print("Enter Your Name : ");
                    this.name = sc.nextLine();
                    System.out.print("Enter Your AccountNumber : ");
                    this.accountNumber = sc.nextLine();
                    System.out.print("Enter Withdraw amount : ");
                    amount = sc.nextDouble();
                    mf.withdraw(amount);
//                        while (true){
//                            char ch;
//                            System.out.print("Do you want to Withdraw more fund ?(Y/N) : ");
//                            ch = sc.next().charAt(0);
//                            if(ch=='Y'){
//                                System.out.print("Enter Withdraw amount : ");
//                                amount = sc.nextDouble();
//                                mf.withdraw(amount);
//                            }else{
//                                break;
//                            }
//                        }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.print("Enter Your Name : ");
                    this.name = sc.nextLine();
                    System.out.print("Enter Your AccountNumber : ");
                    this.accountNumber = sc.nextLine();
                    System.out.print("Enter The AccountNumber You Want To Send Money: ");
                    this.receiverAccountNumber = sc.nextLine();
                    System.out.print("Enter The Amount: ");
                    amount = sc.nextDouble();
                    mf.transfer(amount, receiverAccountNumber);
                    break;
                case 4:
                    mf.checkBalance();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
            if (choice == 4) {
                break;
            }
        }

    }
}
