
import java.io.IOError;
import  java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
    Scanner sc1 = new Scanner(System.in);

    Bank bank = new Bank();
    Menu menu = new Menu(bank);


    menu.StartingMenu();

    if(Menu.isAuth)
    {
        menu.MainMenu();
    }
}}