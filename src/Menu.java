import java.util.Scanner;

public class Menu {

    public static boolean isAuth = false;


    public static boolean StartingMenu()
    {
        while(!isAuth)
        {
            System.out.println("====================");
            System.out.println("Welcome to Java Bank ");
            System.out.println("====================");

            System.out.println("Press 1 to Create Account ");
            System.out.println("Press 2 to Login in ");

            Scanner sc1 = new Scanner(System.in);
            int result1 = Integer.parseInt(sc1.nextLine());


            if(result1 == 1)
            {


                boolean res = Bank.CreateAccont();

                if(res)
                {
                    System.out.println("Account Created Sucessfully");
                    Menu.isAuth = true;
                    return true;
                }else{
                    System.out.println("Failed to Create an account");
                    return false;
                }


            }else if(result1 == 2)
            {

            }else{
                System.out.println("Pleace pick Between 1 to 2");
            }
        }

        return false;

    }

}
