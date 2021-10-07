package www.mfachriadrianta.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) throws IOException {
        checkingData();
    }

    private static void checkingData() throws IOException{

        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("database.txt");
            bufferedReader = new BufferedReader(fileReader);
            String dataUsername = bufferedReader.readLine();
            String dataPassword = bufferedReader.readLine();
            boolean next = true;

            while (next){
                clearScreen();
                System.out.println("");
                System.out.println("Login");
                Scanner systemInput = new Scanner(System.in);
                String edt_username, edt_password;
                System.out.print("Username : ");
                edt_username = systemInput.nextLine();
                System.out.print("Password : ");
                edt_password = systemInput.nextLine();

                if(!edt_username.equalsIgnoreCase(dataUsername) && !edt_password.equalsIgnoreCase(dataPassword)){
                    System.out.println("Login failed!");
                } else {
                    return;
                }

                next = repeatLogin("Are you want next ? ");
            }
            }catch (Exception e){
            System.err.println("Nothing data");
            }
    }

    private static void clearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.println("\033\143");
            }
        }catch (Exception e){
            System.err.println("Can not proccess clear system!");
        }
    }

    private static boolean repeatLogin(String message){
        Scanner inputOne = new Scanner(System.in);
        System.out.print(message + "Yes or No ?");
        String inputUser = inputOne.next();

        while (!inputUser.equalsIgnoreCase("Yes") && !inputUser.equalsIgnoreCase("No")){
            System.err.println("Your only choice Yes or No!");
            inputUser = inputOne.next();
            System.out.print(message);
        }

        return inputUser.equalsIgnoreCase("Yes");
    }
}