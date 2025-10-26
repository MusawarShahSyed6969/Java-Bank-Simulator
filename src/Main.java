
import java.io.IOError;
import  java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
    Scanner sc1 = new Scanner(System.in);

//        Bank ac1 = new Bank(1,"Musawar");
//
//
//        ac1.GetDetails();


       while(true)
        {
            System.out.println("====================");
            System.out.println("Welcome to Java Bank ");
            System.out.println("====================");

            System.out.println("Press 1 to Create Account ");
            System.out.println("Press 2 to Login in ");

            int result1 = Integer.parseInt(sc1.nextLine());


            if(result1 == 1)
            {


                boolean res = Bank.CreateAccont();

                if(res)
                {
                    System.out.println("Account Created Sucessfully");
                }else{
                    System.out.println("Failed to Create an account");
                }


            }else if(result1 == 2)
            {

            }else{
                System.out.println("Pleace pick Between 1 to 2");
            }
        }





}}