package net.preibisch.biglogger.handlers;

import net.preibisch.biglogger.generic.ApplicationMode;
import net.preibisch.biglogger.generic.LogHandler;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

@LogHandler(format = "terminal", type = {ApplicationMode.Headless})
public class TerminalLogHandler extends Handler {

    private static final Formatter defaultFormatter = new SimpleFormatter();

    @Override
    public void publish(final LogRecord record) {
        final String msg;
        if (getFormatter() == null) {
            msg = this.defaultFormatter.format(record);
        } else {
            msg = getFormatter().format(record);
        }
        System.out.println(msg);


    }

    @Override
    public void flush() {
    }

    @Override
    public void close() {
    }


}
