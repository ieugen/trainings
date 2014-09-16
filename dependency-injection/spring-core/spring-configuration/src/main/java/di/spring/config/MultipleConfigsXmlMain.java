package di.spring.config;

import di.spring.config.multiple.FooFoo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MultipleConfigsXmlMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("multiple/foo-foo.xml");
        FooFoo fooFoo = context.getBean(FooFoo.class);

        fooFoo.makeMoreFoo();
    }
}
