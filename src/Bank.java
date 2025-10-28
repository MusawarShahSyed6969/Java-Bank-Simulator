import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Bank {

      ArrayList<Account> Accounts = new ArrayList<>();

      public  Account currentUser = null;


    Scanner sc1 = new Scanner(System.in);




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

    public boolean LoginAccount (Menu menu)
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
                    menu.MainMenu();
                    return true;
                }
            }

        }
        System.out.println("❌ Invalid account or PIN.");
        return  false;
    }

    public void DepositMoney(Account user,int amount) {
       user.balance += amount;
        System.out.println("✅ Money Deposited Successfully " + amount);
    }

    public void WithdrawMoney(Account user,int amount) {
        if (user.balance >= amount) {
            user.balance -= amount;
            System.out.println("✅ Money Withdrawed Successfully " + amount);
        }else{
            System.out.println("❌ You do not have enough funds to withdraw");
    }
    }


    public void ChangePin(Account user,int oldPin, int newPin)
    {
        if(user != null && user.pin == oldPin)
        {
            user.pin = newPin;
            System.out.println("✅ Pin Changed Successfully " + user.ownerName);
        }else{
            System.out.println("❌ Failed to change pincode");
        }
    }

    public void DeleteAccount(Account user) {
        if (user == null) {
            System.out.println("⚠️ Cannot delete: user is null");
            return;
        }

        boolean deleted = false;

        // Go through all accounts safely
        Iterator<Account> iterator = Accounts.iterator();
        while (iterator.hasNext()) {
            Account acc = iterator.next();

            // Check if this is the account we want to delete
            if (user.accountNumber == acc.accountNumber) {
                iterator.remove(); // ✅ safe way to remove
                System.out.println("✅ Account Deleted Successfully: " + user.ownerName);
                deleted = true;
                break; // stop, no need to keep checking
            }
        }

        if (!deleted) {
            System.out.println("❌ Account not found, cannot delete");
        }
    }

}
