package comm.example2;

import java.util.Scanner;

public class Tester extends UserMainClass{
    public static void main(String args[]) throws InvalidPasswordException {
        for(int i=0;i<2;i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the password");
            String password1 = sc.next();
            try {
                System.out.println("Is Password " + password1 + " Valid?");
                checkPassword(password1);
                System.out.println("Valid Password");
            } catch (InvalidPasswordException e) {
                System.out.println(e.getMessage());
                System.out.println(e.printMessage());
            }
        }
       /* String password2="Geek007@GFG";
        try{
            System.out.println("\nIs Password "+password2+" Valid?");
            checkPassword(password2);
            System.out.println("Valid Password.");
        }catch (InvalidPasswordException e){
            System.out.println(e.getMessage());
            System.out.println(e.printMessage());
        }*/
    }
}
