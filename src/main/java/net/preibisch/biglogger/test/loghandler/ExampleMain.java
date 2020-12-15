package net.preibisch.biglogger.test.loghandler;

import net.preibisch.biglogger.handlers.TerminalLogger;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ExampleMain {

    public static void main(String[] args) {
        //reset() will remove all default handlers
        LogManager.getLogManager().reset();
        Logger rootLogger = LogManager.getLogManager().getLogger("t");

        rootLogger.addHandler(new MyLogHandler());
        rootLogger.addHandler(new TerminalLogger());
        AppClass appClass = new AppClass();
        appClass.doSomething();
        rootLogger.info("some message");

    }
}