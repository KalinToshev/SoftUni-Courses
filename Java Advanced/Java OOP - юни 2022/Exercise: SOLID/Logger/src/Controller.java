import appenders.Appender;
import appenders.ConsoleAppender;
import appenders.FileAppender;
import layouts.Layout;
import layouts.SimpleLayout;
import layouts.XMLLayout;
import loggers.Logger;
import loggers.MessageLogger;
import utilities.LogFile;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int appendersCount = Integer.parseInt(scanner.nextLine());

        Map<Appender, MessageLogger.LogLevel> appenderLogLevelMap = new LinkedHashMap<>();

        while (appendersCount-- > 0) {

            String[] tokens = scanner.nextLine().split("\\s+");

            String appenderType = tokens[0];
            String layoutType = tokens[1];
            MessageLogger.LogLevel logLevel = tokens.length == 3
                    ? MessageLogger.LogLevel.valueOf(tokens[2])
                    : MessageLogger.LogLevel.INFO;

            Layout layout = createLayout(layoutType);
            Appender appender = createAppender(appenderType, layout);

            appenderLogLevelMap.put(appender,logLevel);

        }

        Logger logger = new MessageLogger(appenderLogLevelMap);

        String line = scanner.nextLine();

        while (!line.equals("END")) {

            String[] tokens = line.split("\\|");

            MessageLogger.LogLevel logLevel = MessageLogger.LogLevel.valueOf(tokens[0]);

            String timeStamp = tokens[1];
            String message = tokens[2];

            switch (logLevel) {
                case INFO -> logger.logInfo(timeStamp, message);
                case WARNING -> logger.logWarning(timeStamp, message);
                case ERROR -> logger.logError(timeStamp, message);
                case CRITICAL -> logger.logCritical(timeStamp, message);
                case FATAL -> logger.logFatal(timeStamp, message);
            }

            line = scanner.nextLine();

        }

        System.out.println(logger.toString());

    }

    private static Appender createAppender(String appenderType, Layout layout) {
        return appenderType.equals("ConsoleAppender")
                ? new ConsoleAppender(layout) : new FileAppender(layout, new LogFile());
    }

    private static Layout createLayout(String layoutType) {

        return layoutType.equals("SimpleLayout")
                ? new SimpleLayout() : new XMLLayout();

    }
}
