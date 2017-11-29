package ua.epam.spring.core.loggers;

import org.apache.commons.io.FileUtils;
import ua.epam.spring.core.beans.Event;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String filename;
    private File file;

    public FileEventLogger(String s) {
        filename = s;
    }

    public void init() throws IOException {
        file = new File(filename);
        if (!file.canWrite()) {
            throw new IOException(filename + " is not writable");
        }
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(new File(filename), event.toString() + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
