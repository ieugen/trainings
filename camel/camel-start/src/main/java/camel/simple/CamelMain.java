package camel.simple;

import org.apache.camel.CamelContext;
import org.apache.camel.component.jpa.JpaComponent;
import org.apache.camel.impl.DefaultCamelContext;

import java.util.concurrent.TimeUnit;

public class CamelMain {


    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new FileTransferRoute());
        context.addRoutes(new SecondRoute());

//        context.addComponent();

        context.start();
        TimeUnit.SECONDS.sleep(30);
        context.stop();
    }
}
