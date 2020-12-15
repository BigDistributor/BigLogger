package net.preibisch.biglogger.generic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Indexable
public @interface LogHandler {

    String format();

    ApplicationMode[] type();

    double priority() default 0.0D;
}
