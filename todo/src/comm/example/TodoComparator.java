package comm.example;

import java.util.Comparator;
import java.util.Date;

public class TodoComparator implements Comparator{
    @Override
    public int compare(Object o, Object t1) {
        Todo todo1=(Todo) o;
        Todo todo2=(Todo) t1;
        if(todo1.getTargetDate()==todo2.getTargetDate())
        {
            return 0;
        }
        else if(todo1.getTargetDate().before(todo2.getTargetDate()))
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }
}
