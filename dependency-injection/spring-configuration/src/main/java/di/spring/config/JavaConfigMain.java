package di.spring.config;

import di.spring.config.java.Bar;
import di.spring.config.java.Baz;
import di.spring.config.java.Foo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class JavaConfigMain {

    public static void main(String[] args) throws Exception {

        // No Spring classes in any class under java package. You can use it with old code.
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Foo javaFoo = (Foo) context.getBean("foo");
        System.out.println(javaFoo.makeSomeFoo());
    }

    @Configuration
    public static class AppConfig {

        @Bean
        public Foo foo() {
            return new Foo(new Bar(), baz());
        }

        @Bean
        public Baz baz() {
            return new Baz();
        }
    }
}
