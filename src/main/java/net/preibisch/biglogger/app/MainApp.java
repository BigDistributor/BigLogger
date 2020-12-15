package net.preibisch.biglogger.app;


import net.preibisch.biglogger.generic.IndexableManager;
import net.preibisch.biglogger.generic.LogHandler;

import java.util.Arrays;
import java.util.Set;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@BigDistributorApp(type = ApplicationMode.Headless)
public abstract class MainApp {

    public MainApp() {

        Class<? extends MainApp> cls = this.getClass();
        System.out.println("Main App: " + cls);
        BigDistributorApp dist = cls.getAnnotation(BigDistributorApp.class);
        System.out.println("App Type: " + dist.type());
        initLogger(dist.type());
    }

    private void initLogger(ApplicationMode type) {
        Set<Class<?>> logHandlers = IndexableManager.getClassesForAnnotation(LogHandler.class);
        LogManager.getLogManager().reset();
        Logger rootLogger = LogManager.getLogManager().getLogger("");

        logHandlers.stream().forEach(c -> {
            try {
                if (Handler.class.isAssignableFrom(c))
                    if (Arrays.asList(c.getAnnotation(LogHandler.class).type()).contains(type))
                        rootLogger.addHandler(Handler.class.cast(c.newInstance()));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

    }
}
