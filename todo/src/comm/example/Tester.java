package comm.example;

import java.util.Date;
import java.util.TreeSet;

public class Tester {
    public static void main(String args[])
    {
        TodoComparator comparator=new TodoComparator();
        TreeSet<Todo> set = new TreeSet<Todo>();
        set.add(new Todo("id1","demo desc1",new Date("2021/03/12"),false));
        set.add(new Todo("id1","demo desc2",new Date("2021/03/10"),false));
        set.add(new Todo("id3","demo desc3",new Date("2021/02/12"),false));
        set.add(new Todo("id3","demo desc3",new Date("2021/01/12"),false));
        for(Todo t:set)
        {
            System.out.println(t);
        }
    }
}
