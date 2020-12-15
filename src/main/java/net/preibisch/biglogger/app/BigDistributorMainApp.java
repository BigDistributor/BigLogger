package net.preibisch.biglogger.app;


import net.preibisch.biglogger.generic.IndexableManager;
import net.preibisch.biglogger.generic.LogHandler;

import java.util.Arrays;
import java.util.Set;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Class {@code Logger} is the main root of BigDistributor.
 * Any Main app will need to extends from this class
 * App have 4 modes: Fiji, Headless, Cluster, Cloud
 * And based on mode the LogHandler will be initiated
 *
 * @author Marwan Zouinkhi
 * @see ApplicationMode
 * @since V0.1
 */
@BigDistributorApp(type = ApplicationMode.Headless)
public abstract class BigDistributorMainApp {

    public BigDistributorMainApp() {
        System.out.println("Main App: " + this.getClass());
        BigDistributorApp dist = this.getClass().getAnnotation(BigDistributorApp.class);
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
