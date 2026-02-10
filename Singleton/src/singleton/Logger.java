package singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private BufferedWriter writer;
    private String fileName;

    private Logger() {
        fileName = "log.txt";
        openWriter(fileName);
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public synchronized void setFileName(String newFileName) {
        if (newFileName == null || newFileName.isEmpty()) {
            return;
        }
        close();
        fileName = newFileName;
        openWriter(fileName);
    }

    public synchronized void write(String message) {
        if (writer == null) {
            return;
        }
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.err.println("Failed to write log message: " + e.getMessage());
        }
    }

    public synchronized void close() {
        if (writer == null) {
            return;
        }
        try {
            writer.close();
        } catch (IOException e) {
            System.err.println("Failed to close log file: " + e.getMessage());
        } finally {
            writer = null;
        }
    }

    private void openWriter(String targetFile) {
        try {
            writer = new BufferedWriter(new FileWriter(targetFile, true));
        } catch (IOException e) {
            writer = null;
            System.err.println("Failed to open log file: " + e.getMessage());
        }
    }
}
