import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

      ArrayList<Account> Accounts = new ArrayList<>();

      public static Account currentUser = null;


    Scanner sc1 = new Scanner(System.in);

    int currentMoney = 0;


    public void GetAccountsDetail() {
        // Fix: loop condition should be i < size()
        for (Account acc : Accounts) {
            System.out.println("Account Number: " + acc.accountNumber
                    + " | Name: " + acc.ownerName
                    + " | Balance: " + acc.balance
                    + " | PIN: " + acc.pin);
        }

    }

    public boolean CreateAccont() {

        System.out.println("Enter your Name");
        String nam = sc1.nextLine();

        System.out.println("New Account Number");
        int num = Integer.parseInt(sc1.nextLine());

        System.out.println("Enter new pin");
        int pincode = Integer.parseInt(sc1.nextLine());

        int balance = 0;

        if (nam.length() >= 1 && num != 0 && pincode != 0) {

            // Fix: Add the new account to the Account class ArrayLists
            Accounts.add(new Account(num,nam,balance,pincode));
            System.out.println("✅ Account created successfully!");

            GetAccountsDetail();
            return true;
        } else {
            System.out.println("❌ Please Fill all the Fields");
            return false;
        }
    }

    public boolean LoginAccount ()
    {
        System.out.println("New Account Number");
        int num = Integer.parseInt(sc1.nextLine());

        System.out.println("Enter new pin");
        int pincode = Integer.parseInt(sc1.nextLine());

        for (Account acc : Accounts)
        {
            if ( num == acc.accountNumber )
            {
                if(pincode == acc.pin)
                {
                    currentUser = acc;
                    System.out.println("Welcome " + currentUser.ownerName);
                    System.out.println("✅Login Sucesfull");
                    Menu.isAuth = true;
                    return true;
                }
            }

        }
        System.out.println("❌ Invalid account or PIN.");
        return  false;
    }

    public void DepositMoney(int amount) {
        currentMoney = amount;
    }

    public void WithdrawMoney(int amount) {
        if (currentMoney >= amount) {
            currentMoney -= amount;
            System.out.println("✅ Money Withdrawed Successfully " + amount);
        }
    }
}
