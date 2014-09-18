package di.spring.extensions;

import di.spring.extensions.custom.IBar;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertyOverrideMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("property-override.xml");
        context.registerShutdownHook();

        IBar bar = context.getBean(IBar.class);

        bar.printIt();

    }
}
