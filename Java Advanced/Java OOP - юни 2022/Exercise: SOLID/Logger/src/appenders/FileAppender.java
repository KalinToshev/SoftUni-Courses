package appenders;

import layouts.Layout;
import loggers.MessageLogger;
import utilities.File;

public class FileAppender extends BaseAppender {

    private File file;

    public FileAppender(Layout layout, File file) {
        super(layout);
        this.file = file;
    }

    @Override
    public void append(String timeStamp, MessageLogger.LogLevel logLevel, String message) {
        counter++;
        file.write(getLayout().format(timeStamp, logLevel, message));
    }

    public File getFile() {
        return file;
    }
}
