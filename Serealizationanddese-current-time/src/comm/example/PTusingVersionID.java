package comm.example;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class PTusingVersionID implements Serializable
{
    static final long serialVersionUID = -3126998878902358585L;

    private Date time;
    private String aNewField;

    public PTusingVersionID() {
        time = Calendar.getInstance().getTime();
    }

    public Date getTime() {
        return time;
    }
}
