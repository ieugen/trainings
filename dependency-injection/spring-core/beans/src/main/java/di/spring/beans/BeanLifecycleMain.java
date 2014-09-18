package di.spring.beans;

import di.spring.beans.lifecycle.Foo;
import di.spring.beans.lifecycle.FooAnnotations;
import di.spring.beans.lifecycle.FooAware;
import di.spring.beans.lifecycle.FooCustomMethods;
import di.spring.beans.lifecycle.FooInitAndDisposable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifecycleMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CustomMethodsConfig.class);

        Foo foo = context.getBean(FooCustomMethods.class);
        Foo initAndDisposable = context.getBean(FooInitAndDisposable.class);
        Foo fooAnnotations = context.getBean(FooAnnotations.class);
        Foo fooAware = context.getBean(FooAware.class);

        // closing the application context calls the destroy methods
//        context.close();
        // register a ShutdownHook if you don't call context.close() manually
        context.registerShutdownHook();
    }

    @Configuration
    public static class CustomMethodsConfig {
        @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
        public FooCustomMethods foo() {
            return new FooCustomMethods();
        }

        @Bean
        public FooInitAndDisposable fooInitAndDisposable() {
            return new FooInitAndDisposable();
        }

        @Bean
        public FooAnnotations fooAnnotations() {
            return new FooAnnotations();
        }

        @Bean
        public FooAware fooAware() {
            return new FooAware();
        }
    }

}
