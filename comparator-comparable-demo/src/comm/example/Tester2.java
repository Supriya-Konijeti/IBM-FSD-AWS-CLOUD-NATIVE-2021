package comm.example;

import java.util.ArrayList;
import java.util.List;

public class Tester2 {
    public static void printNames(List<? extends Account> lea) {
        for (int i=0; i < lea.size(); i++) {
            System.out.println(lea.get(i).getAccountName());
        }
    }
    public static void main(String[] args) {
        List<CurrentAccount> lc = new ArrayList<CurrentAccount>();
        lc.add(new CurrentAccount(11,"AA",30000));
        List<SavingsAccount> ls = new ArrayList<SavingsAccount>();
        ls.add(new SavingsAccount(12,"cc",3000));
        printNames(lc);
        printNames(ls);
//but...
        List<CurrentAccount> leo = lc; //OK
        System.out.println(leo);
        List<SavingsAccount> leo1=ls;
        System.out.println(leo1);
        leo.add(new CurrentAccount(1,"Fred",30000));//Compile error!
    }
}
