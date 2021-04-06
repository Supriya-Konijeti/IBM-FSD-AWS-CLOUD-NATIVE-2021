package comm.example;
import java.io.*;
import java.util.Scanner;
public class Employeefactory1 {
    public static void main(String args[]) throws IOException {
        String empID;
        String fname;
        String lname;
        String email;
        Employee e= new Employee();
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the employee id: ");
        empID = sc.next();
        System.out.println("Enter the employee firstname: ");
        fname = sc.next();
        System.out.println("Enter the employee last name: ");
        lname = sc.next();
        System.out.println("Enter the employee email: ");
        email = sc.next();
        String text= "\n"+empID+","+fname+","+lname+","+email;
        File f = new File ("Employe.txt");
        FileWriter fw= new FileWriter(f,true);
        fw.append(text);
        fw.flush();
        fw.close();
    }
}
