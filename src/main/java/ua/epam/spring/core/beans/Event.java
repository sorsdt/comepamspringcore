package ua.epam.spring.core.beans;

import java.util.Date;
import java.util.Random;

public class Event {
    private int id = new Random().nextInt(100);
    private String msg;
    private Date date;

    public Event() {
    }

    public Event(Date date) {
        this.date = date;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }
}
