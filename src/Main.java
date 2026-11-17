import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        short pinCode = 1234;
        float initialBalance = 2500.75f;
        float currentBalance = initialBalance;

        System.out.println("========= ATM =========");
        System.out.println("Pleas Enter Your Pin Code : ");
        for(byte i = 1; i <= 3 ; i++) {
            int customerPinInput = scan.nextInt();
            if (customerPinInput == pinCode) {
                int customerSelect;
                do {
                    System.out.println("========= ATM =========");
                    System.out.println("1. Check Balance");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Show Account Status");
                    System.out.println("5. Exit");
                    System.out.println("=======================");

                    customerSelect = scan.nextInt();
                    switch (customerSelect) {
                        case 1:
                            System.out.println("Your current balance is " + currentBalance);
                            break;
                        case 2:
                            System.out.println("Please Enter Your Deposit Amount: ");
                            float depositAmount = 0f;
                            while(depositAmount <= 0) {
                                depositAmount = scan.nextFloat();
                                if(depositAmount <= 0) {
                                    System.out.println("Invalid amount, Please Enter a valid amount : ");
                                }
                            }
                            currentBalance += depositAmount;
                            System.out.println("Successful Deposit!");
                            System.out.println("Your Current Balance is : " + currentBalance);
                            break;
                        case 3:
                            System.out.println("Please Enter your Withdraw Amount: ");
                            float withdrawAmount = 0f;
                            while(withdrawAmount <= 0 || withdrawAmount > currentBalance) {
                                withdrawAmount = scan.nextFloat();
                                if(withdrawAmount < 0 ) {
                                    System.out.println("Insufficient balance. Please Enter a valid amount :");
                                }
                                if(withdrawAmount == 0) {
                                    System.out.println("Transaction Canceled!, Please Enter a valid amount");
                                } else if (withdrawAmount > currentBalance) {
                                    System.out.println("Transaction Canceled!, Please Enter a valid amount");
                                }
                            }
                            currentBalance -= withdrawAmount;
                            System.out.println("Successful Withdraw!");
                            System.out.println("Your Current Balance is : " + currentBalance);
                            if(currentBalance == 0.0) {
                                System.out.println("Warning: Your account is Empty");
                            }
                            break;
                        case 4:
                            if (currentBalance >= 5000) {
                                System.out.println("== VIP Customer ==");
                            } else if (currentBalance > 1000) {
                                System.out.println("== Regular Customer ==");
                            } else {
                                System.out.println("== Low Balance ==");
                            }
                            break;
                        case 5:
                            System.out.println("Your Current Balance is : " + currentBalance);
                            if(currentBalance == 0) {
                                System.out.println("'Warning: Your account is empty.");
                            }
                            System.out.println("Thank you for using our ATM.");
                            break;
                        default:
                            System.out.println("Invalid Choice, Please Choose from 1 to 5");
                            break;
                    }
                } while (customerSelect != 5);
                    break;
            } else if (i == 3) {
                System.out.println("Your account has been locked.");
                break;
            }
            else {
                System.out.println("Please Enter a Valid number : ");
                System.out.println("you have " + (3-i) + " attempts");
            }
        }
    }
}