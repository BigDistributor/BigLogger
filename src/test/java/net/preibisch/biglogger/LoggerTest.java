package net.preibisch.biglogger;

import net.preibisch.biglogger.data.App;
import net.preibisch.biglogger.data.HelloClass;
import org.junit.Test;

public class LoggerTest {

    @Test
    public void serializeCarObjectEnsureCorrectOutputJson() throws Exception {
        new HelloClass().sayHello();
        new App();
        new HelloClass().sayHello();
    }
}
