package net.preibisch.biglogger.app;

import net.preibisch.biglogger.generic.IndexableClass;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@IndexableClass
public @interface BigDistributorApp {

    ApplicationMode type();

}
