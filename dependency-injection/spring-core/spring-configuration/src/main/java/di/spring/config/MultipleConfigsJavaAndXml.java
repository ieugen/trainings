package di.spring.config;

import di.spring.config.multiple.FooFoo;
import di.spring.config.multiple.FooFooAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MultipleConfigsJavaAndXml {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(FooFooAppConfig.class);
        FooFoo fooFoo = context.getBean(FooFoo.class);

        fooFoo.makeMoreFoo();
    }
}
