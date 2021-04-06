package comm.example2;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class PersistantTime implements Serializable {
    transient private Date time;

    public PersistantTime() {
        time = Calendar.getInstance().getTime();
    }

    public Date getTime() {
        return time;
    }
}
