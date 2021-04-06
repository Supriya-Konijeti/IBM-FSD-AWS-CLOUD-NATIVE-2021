package comm.exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
public class Tester1 {
    public static void main(String[] args) throws IOException, ParseException {
        // TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input the number of employees :");
        int n=Integer.parseInt(br.readLine());
        List<Employee>employeeList=new ArrayList<Employee>();
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the details for employee "+(i+1));
            String name=br.readLine();
            String department=br.readLine();
            Date dateOfJoining=new SimpleDateFormat("MM/dd/yyyy").parse(br.readLine());
            int age=Integer.parseInt(br.readLine());
            int salary=Integer.parseInt(br.readLine());
            Employee e=new Employee(name,department,dateOfJoining,age,salary);
            employeeList.add(e);
        }
        System.out.println("1.Sort employees by salary");
        System.out.println("2.Sort employees by age and by date of joining");
        System.out.println("Enter your choice");
        int choice=Integer.parseInt(br.readLine());
        switch(choice)
        {
            case 1:

                Emplyeecomp.printEmployees(employeeList);
                break;
            case 2:
                Collections.sort(employeeList,new AgeComparator());
                Emplyeecomp.printEmployees(employeeList);


        }
    }

}
