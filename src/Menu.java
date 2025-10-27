import java.util.Scanner;

public class Menu {

    public static boolean isAuth = false;
    private Bank bank;

    Scanner sc1 = new Scanner(System.in);

    public Menu(Bank bank)
    {
        this.bank = bank;
    }

    public  void StartingMenu()
    {

        while(!isAuth)
        {
            System.out.println("====================");
            System.out.println("Welcome to Java Bank ");
            System.out.println("====================");

            System.out.println("Press 1 to Create Account ");
            System.out.println("Press 2 to Login in ");


            int result1 = Integer.parseInt(sc1.nextLine());


            if(result1 == 1)
            {


                boolean res = bank.CreateAccont();

                if(!res)
                {
                    System.out.println("Failed to Create an account");
                }

            }else if(result1 == 2)
            {
                bank.LoginAccount();
            }else{
                System.out.println("Pleace pick Between 1 to 2");
            }
        }

    }


    public void MainMenu()
    {
        if(Bank.currentUser != null)
        {
            System.out.println("====================");
            System.out.println("Welcome " + bank.currentUser.ownerName + " into Java Bank ");
            System.out.println("====================");

            System.out.println("************************");
            System.out.println("You Current Money is : " + bank.currentUser.balance);
            System.out.println("************************");

            System.out.println("Press 1 to Desposit Money");
            System.out.println("Press 2 to Withdraw Money");
            System.out.println("Press 3 to Change Pin");
            System.out.println("Press 4 to Delete Account");

            System.out.println("***********************");
            int result = Integer.parseInt(sc1.nextLine());


        }else{
            System.out.println("Current User Not Found");
        }
    }
}
