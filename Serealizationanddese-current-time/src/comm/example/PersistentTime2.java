package comm.example;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class PersistentTime2 implements Serializable {
    private Date time;
    private String aNewField;

    public PersistentTime2() {
        time = Calendar.getInstance().getTime();
    }

    public Date getTime() {
        return time;
    }
}
