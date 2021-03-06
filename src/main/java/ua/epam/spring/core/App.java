package ua.epam.spring.core;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.epam.spring.core.beans.Client;
import ua.epam.spring.core.beans.Event;
import ua.epam.spring.core.loggers.EventLogger;

import java.util.List;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private List<String> eventMessages;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        for (String message : app.eventMessages) {
            Event event = (Event) ctx.getBean("event");
            event.setMsg(message);
            app.logEvent(event);
        }
        ctx.close();
    }

    private void logEvent(Event event) {
        String message = event.getMsg().replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }

    public void setEventMessages(List<String> eventMessages) {
        this.eventMessages = eventMessages;
    }
}
