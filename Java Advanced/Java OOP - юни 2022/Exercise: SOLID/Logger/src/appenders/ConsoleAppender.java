package appenders;

import layouts.Layout;
import loggers.MessageLogger;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String timeStamp, MessageLogger.LogLevel logLevel, String message) {
        counter++;
        System.out.println(getLayout().format(timeStamp, logLevel, message));
    }

}
