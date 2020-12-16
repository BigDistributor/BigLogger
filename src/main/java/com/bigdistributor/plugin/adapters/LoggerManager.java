package com.bigdistributor.plugin.adapters;

import app.ApplicationMode;
import com.bigdistributor.plugin.generic.IndexableManager;
import com.bigdistributor.plugin.generic.LogHandler;

import java.util.Arrays;
import java.util.Set;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerManager {

    public static void initLogger(ApplicationMode type) {
        Set<Class<?>> logHandlers = IndexableManager.getClassesForAnnotation(LogHandler.class);
        LogManager.getLogManager().reset();
        Logger rootLogger = LogManager.getLogManager().getLogger("");

        logHandlers.stream().forEach(c -> {
            try {
                if (Handler.class.isAssignableFrom(c))
                    if (Arrays.asList(c.getAnnotation(LogHandler.class).modes()).contains(type))
                        rootLogger.addHandler(Handler.class.cast(c.newInstance()));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

    }
}
