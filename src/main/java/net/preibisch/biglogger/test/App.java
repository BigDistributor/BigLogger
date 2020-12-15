package net.preibisch.biglogger.test;

import net.preibisch.biglogger.generic.ApplicationMode;
import net.preibisch.biglogger.generic.DistributeMainApp;
import net.preibisch.biglogger.generic.MainApp;

@DistributeMainApp(type = ApplicationMode.Headless)
public class App  extends MainApp {
    public static void main(String[] args) {
        new App();
    }
}
