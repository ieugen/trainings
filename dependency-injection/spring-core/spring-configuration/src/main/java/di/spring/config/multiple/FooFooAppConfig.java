package di.spring.config.multiple;

import di.spring.config.java.Bar;
import di.spring.config.java.Baz;
import di.spring.config.java.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"annotations/foo-annotations.xml"})
public class FooFooAppConfig {

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
