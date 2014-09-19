package di.spring.testing;

import di.spring.testing.model.Foo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProfilesMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        context.getEnvironment().setActiveProfiles("prod");
        context.register(AppConfig.class);
        context.refresh();


        Foo foo = context.getBean(Foo.class);

        foo.printIt();
    }

}
