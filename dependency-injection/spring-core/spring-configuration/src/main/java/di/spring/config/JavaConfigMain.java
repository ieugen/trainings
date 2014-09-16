package di.spring.config;

import di.spring.config.java.AppConfig;
import di.spring.config.java.Foo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigMain {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Foo javaFoo = (Foo) context.getBean("foo");
        System.out.println(javaFoo.makeSomeFoo());
    }
}
