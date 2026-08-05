package org.example;

import java.util.Scanner;
import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        System.out.println(Locale.getDefault());

        final int PIN = 1234;
        int attempts = 3;

        while(attempts > 0) {
            System.out.print("Enter a 4-digit PIN: ");
            int pin = scanner.nextInt();
            if(pin == PIN) {
                System.out.println("PIN accepted, Welcome!");
                break;
            }
            attempts--;

            if(attempts > 0) {
                System.out.println("Incorrect PIN, Attempts remaining: " + attempts);
            }

        }
        if(attempts == 0) {
            System.out.println("Your account has been locked.");
            scanner.close();
            return;
        }

        double balance = 2500.75;
        do {

            System.out.println("============== ATM ============");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Account Status");
            System.out.println("5. Exit");
            System.out.println("===============================");

            System.out.print("Choose an option: ");
            byte option = scanner.nextByte();
            switch(option) {
                case 1:
                    System.out.println(balance);
                    break;
                case 2:
                    System.out.print("Add amount of balance: ");
                    double deposit = scanner.nextDouble();

                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("Deposit successful.");
                        System.out.println("Current Balance: " + balance);
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case 3:
                    System.out.println("Enter amount to withdraw");
                    double withdraw = scanner.nextDouble();
                    if(withdraw <= 0) {
                        System.out.println("Invalid amount.");
                    } else if(withdraw > balance) {
                        System.out.println("Insufficient balance.");
                    }else {
                        balance -= withdraw;
                        System.out.println("withdraw successful.");
                        System.out.println("Current Balance: " + balance);
                    }
                    break;
                case 4:
                    System.out.println("VIP Customer (>= 5000");
                    System.out.println("Regular Customer (1000-4999.99");
                    System.out.println("Low Balance (<1000");
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM.");
                    return;
                default:
                    System.out.println("Invalid Option.");
                    return;
            }
        } while(true);

    }
}
