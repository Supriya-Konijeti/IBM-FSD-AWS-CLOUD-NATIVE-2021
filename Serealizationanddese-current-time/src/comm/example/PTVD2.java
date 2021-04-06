package comm.example;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class PTVD2 implements Serializable{
        static final long serialVersionUID = -3126998878902358585L;

        private Date time;
        private String aNewField;
        private String aNewNewField;

        public PTVD2() {
            time = Calendar.getInstance().getTime();
        }

        public Date getTime() {
            return time;
        }
        }
