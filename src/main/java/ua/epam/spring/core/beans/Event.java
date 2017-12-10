package ua.epam.spring.core.beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

public class Event {
    private int id = new Random().nextInt(100);
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    public Event() {
    }

    public Event(Date date) {
        this.date = date;
    }

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
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
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
