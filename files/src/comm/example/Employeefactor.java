package comm.example;

import java.io.*;
import java.util.*;

public class Employeefactor extends Employee  {
    public static void main(String args[]) throws IOException {
        ArrayList<Employee> emp = new ArrayList<Employee>();
        Employee e = new Employee();
        BufferedReader br = new BufferedReader(new FileReader("Employe.txt"));
        String line="";
        try{
            while(br!=null) {
                if((line = br.readLine()) != null) {
                    //e= new Employee();
                    String data[] = line.split(",");
                    for (int i = 0; i < data.length; i++) {
                        e.setId(data[0]);
                        e.setfname(data[1]);
                        e.setlname(data[2]);
                        e.setemail(data[3]);
                    }
                    emp.add(e);
                }
            }
            System.out.println(emp.toString());
            br.close();
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}