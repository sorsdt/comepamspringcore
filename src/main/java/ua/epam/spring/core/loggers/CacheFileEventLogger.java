package ua.epam.spring.core.loggers;

import ua.epam.spring.core.beans.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache = new ArrayList<>();

    public CacheFileEventLogger(String s, int cacheSize) {
        super(s);
        this.cacheSize = cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void logEvent(Event event){
        cache.add(event);
        if (cache.size() >= cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    public void destroy(){
            writeEventsFromCache();
    }

    private void writeEventsFromCache() {
        for (Event event : cache) {
            super.logEvent(event);
        }
    }
}
