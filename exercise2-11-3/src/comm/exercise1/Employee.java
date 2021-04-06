package comm.exercise1;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Employee {
    static int count;
    private int id;
    private String name;
    public Employee(String name, String department, Date dateOfJoining, int age, int salary) {
        super();
        id=++count;
        this.name = name;
        this.department = department;
        this.dateOfJoining = dateOfJoining;
        this.age = age;
        this.salary = salary;
    }
    private String department;
    private Date dateOfJoining;
    private int age;
    private int salary;
    public static int getCount() {
        return count;
    }
    public static void setCount(int count) {
        Employee.count = count;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public Date getDateOfJoining() {
        return dateOfJoining;
    }
    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        System.out.format("%-15s %-30s %-30s %-20s %-10s %-10s\n",id,name,department,new SimpleDateFormat("MM/dd/yyyy").format(dateOfJoining),age,salary);
        return "";

    }

    public int compareTo(Employee e)
    {
        if(salary==e.salary)
            return 0;
        else if(salary>e.salary)
            return 1;
        else
            return -1;
    }

}