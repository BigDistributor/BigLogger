package net.preibisch.biglogger.generic;

/**
 * Class {@code Logger} is the root of the class hierarchy.
 * Every LoggerManager has {@code Logger} as a superclass. All objects,
 * including terminal information, Fiji logging, pipeline management and remote logging implement the methods of this class.
 * In order to be indexed add annotation @LogProcessor, with identifying the context (Fiji, Headless, Cluster, Cloud)
 *
 * @author  Marwan Zouinkhi
 * @see     net.preibisch.biglogger.generic.LogHandler
 * @since   V0.1
 */
public interface BigLogger {
    void log(Object msg);
    void info(Object msg);
    void success(Object msg);
    void error(Object msg);

}
