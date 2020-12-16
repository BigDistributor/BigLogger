/**
 * BigLogger is the manager of Log propagation in different environment
 * Every LoggerManager has {@code Logger} as a superclass. All objects,
 * including terminal information, Fiji logging, pipeline management and remote logging implement the methods of this class.
 * In order to be indexed add annotation @LogProcessor, with identifying the context (Fiji, Headless, Cluster, Cloud)
 *
 * @author Marwan Zouinkhi
 * @since V0.1
 */
module com.biglogger {
    requires kafka.clients;
    requires java.logging;
    requires com.bigdistributor.core;
    requires log4j;
    requires scijava.common;
    exports com.bigdistributor.plugin.adapters;
}