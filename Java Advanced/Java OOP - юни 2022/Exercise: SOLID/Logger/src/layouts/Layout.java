package layouts;

import loggers.MessageLogger;

public interface Layout {

    String format(String timeStamp, MessageLogger.LogLevel logLevel, String message);

}
