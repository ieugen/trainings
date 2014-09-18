package di.spring.extensions;

import di.spring.extensions.custom.Bar;
import di.spring.extensions.custom.BarBeanFactoryPostProcessor;
import di.spring.extensions.custom.Foo;
import di.spring.extensions.custom.FooBeanPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

public class CustomExtensionsMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.registerShutdownHook();

        Foo foo = context.getBean(Foo.class);
        Bar bar = context.getBean(Bar.class);

        bar.printIt();
    }

    @Configuration
    public static class Config {

        @Autowired
        Environment environment;

        @Bean
        public Foo foo() {
            return new Foo();
        }

        @Bean
        public FooBeanPostProcessor fooPostProcessor() {
            return new FooBeanPostProcessor();
        }

        @Bean
        public Bar bar() {
            return new Bar(5);
        }

        @Bean
        public BarBeanFactoryPostProcessor barBeanFactoryPostProcessor() {
            return new BarBeanFactoryPostProcessor(10);
        }
    }
}
