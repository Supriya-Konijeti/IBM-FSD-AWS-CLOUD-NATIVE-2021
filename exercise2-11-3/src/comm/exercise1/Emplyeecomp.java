package comm.exercise1;

import java.util.Comparator;
import java.util.List;

public class Emplyeecomp {
    public static void printEmployees(List<Employee> employeeList)
    {
        System.out.format("%-15s %-30s %-30s %-20s %-10s %-10s\n","Employee ID","Name","Department","Date Of Joining","Age","Salary");
        for(Employee e:employeeList)
            System.out.println(e);
    }

}
