import java.util.Scanner;

public class Bank {



    int AccountNumber;
    String OwnerName;

    int currentMoney = 0;

    public Bank(int number, String name){
        this.AccountNumber = number;
        this.OwnerName = name;
    }


    public void GetDetails()
    {
        System.out.println("Account Number is " + AccountNumber + " Name is " + OwnerName + " current Money is " + currentMoney);
    }



    public static boolean  CreateAccont()
    {
        Scanner sc1 = new Scanner(System.in);

        System.out.println("New Account Number");

        int num =  Integer.parseInt(sc1.nextLine());

        System.out.println("Enter your Name");
        String nam = sc1.nextLine();

        if(nam.length() > 1 && num != 0)
        {
                return true;
        }else {
            System.out.println("Please Fill all the Fields");
            return  false;
        }
    }

    public void DepositMoney(int amount)
    {
        currentMoney = amount;
    }

    public void WithdrawMoney(int amount)
    {
        if(currentMoney >= amount)
        {
            currentMoney -= amount;
            System.out.printf("Money Withdrawed Sucesfully " + amount);
        }
    }


}
