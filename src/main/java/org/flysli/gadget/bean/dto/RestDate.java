package org.flysli.gadget.bean.dto;

import java.util.Date;

public class RestDate {
    private Date start;
    private Date End;

    public RestDate(Date start, Date end) {
        this.start = start;
        End = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return End;
    }

    public void setEnd(Date end) {
        End = end;
    }
}
