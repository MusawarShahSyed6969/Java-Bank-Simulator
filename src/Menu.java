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


    void MainMenuLooper ()
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

    }

    public void MainMenu()
    {
        if(bank.currentUser != null)
        {
            MainMenuLooper();
            int result = Integer.parseInt(sc1.nextLine());
            switch (result)
            {
                case 1:
                    System.out.println("How Much Money you want to Deposit ?");
                    int res1 = Integer.parseInt(sc1.nextLine());

                    bank.DepositMoney(bank.currentUser,res1);
                    System.out.println(+res1+" has been deposited on your account now your total balance is : " + bank.currentUser.balance + "$");
                    MainMenu();
                    break;
                case 2:
                    System.out.println("How Much Money you want to Withdraw ?");
                    int res2 = Integer.parseInt(sc1.nextLine());
                    bank.WithdrawMoney(bank.currentUser,res2);
                    MainMenu();
                    break;

                case 3:
                    System.out.println("You chose 3");
                    break;
                default:
                    System.out.println("Invalid choice");
            }


        } else{
            System.out.println("Current User Not Found");
        }
    }
}
