package net.preibisch.biglogger.handlers;

import net.preibisch.biglogger.generic.ApplicationMode;
import net.preibisch.biglogger.generic.LogHandler;
import org.apache.log4j.BasicConfigurator;
import org.scijava.Context;
import org.scijava.log.LogService;
import org.scijava.ui.swing.console.LoggingPanel;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

@LogHandler(format = "fiji", type = {ApplicationMode.Fiji})
public class FijiLogHandler extends Handler {

    public static Boolean initialized = false;

    private static LogService logService;

    public static void initLogger() {
        if (initialized) return;
        BasicConfigurator.configure();
        final Context context = new Context(LogService.class);
        logService = context.getService(LogService.class);
        initialized = true;
    }

    public static void addListener(LoggingPanel loggingPanel) {
        if (!initialized)
            initLogger();
        logService.addLogListener(loggingPanel);
    }

    public void publish(LogRecord record) {
        if (!initialized)
            initLogger();
        logService.subLogger(record.getSourceClassName()).log(record.getLevel().intValue(), record.getMessage());
    }

    public void flush() {
    }

    public void close() throws SecurityException {
        logService = null;
        initialized = false;

    }
}
