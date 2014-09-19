package di.spring.config;

import di.spring.config.java.Bar;
import di.spring.config.java.Baz;
import di.spring.config.java.Foo;
import di.spring.config.multiple.FooFoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class MultipleConfigsJavaAndXml {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(FooFooAppConfig.class);
        FooFoo fooFoo = context.getBean(FooFoo.class);

        fooFoo.makeMoreFoo();
    }

    @Configuration
    //@ImportResource({"annotations/foo-annotations.xml"})
    @ComponentScan(basePackages = "di.spring.config.annotations")
    public static class FooFooAppConfig {

        @Autowired
        private di.spring.config.annotations.Foo annotationFoo;

        @Bean
        public FooFoo fooFoo() {
            FooFoo fooFoo = new FooFoo(annotationFoo);
            fooFoo.setJavaFoo(javaFoo());
            return fooFoo;
        }

        @Bean
        public Foo javaFoo() {
            return new Foo(new Bar(), new Baz());
        }
    }
}
