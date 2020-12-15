package net.preibisch.biglogger.test;

import net.preibisch.biglogger.generic.LogHandler;
import org.reflections.Reflections;

import java.util.Iterator;
import java.util.Set;

public class GetLoggers {
    public static void main(String[] args) {
        Set<Class<?>> reflections = new Reflections("net.preibisch.biglogger").getTypesAnnotatedWith(LogHandler.class);


        Iterator<Class<?>> itr = reflections.iterator(); // traversing over HashSet
//        System.out.println("Traversing over Set using Iterator");
        while (itr.hasNext()) {
            System.out.println(itr.next().getName());
        }


    }
}
