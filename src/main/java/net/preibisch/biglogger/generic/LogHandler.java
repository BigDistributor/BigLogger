package net.preibisch.biglogger.generic;

import net.preibisch.biglogger.app.ApplicationMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@IndexableClass
public @interface LogHandler {

    String format();

    ApplicationMode[] type();

    double priority() default 0.0D;
}
