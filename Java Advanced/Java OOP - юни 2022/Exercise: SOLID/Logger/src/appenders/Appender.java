package appenders;

import layouts.Layout;
import loggers.MessageLogger;

public interface Appender {

    void append(String timeStamp, MessageLogger.LogLevel logLevel, String message);

    Layout getLayout();

    int getMessagesCount();

}
