package net.preibisch.biglogger.generic;


@DistributeMainApp(type = ApplicationMode.Headless)
public abstract class MainApp {

    public MainApp() {
        Class<? extends MainApp> cls = this.getClass();
        System.out.println("Main App: " + cls);
        DistributeMainApp dist = cls.getAnnotation(DistributeMainApp.class);
        System.out.println("App Type: " + dist.type());
    }
}
