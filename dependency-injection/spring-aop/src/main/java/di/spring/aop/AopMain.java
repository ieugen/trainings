package di.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

public class AopMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.registerShutdownHook();

        Foo foo = context.getBean(Foo.class);

        System.out.println(foo.methodCall("eugen", 3));

    }

    @Configuration
    @EnableAspectJAutoProxy
    public static class Config {

        @Bean
        public Foo foo() {
            return new Foo();
        }

        @Bean
        public MyUselessAspect uselessAspect() {
            return new MyUselessAspect();
        }

        @Bean
        public MyBeforeAspect myBeforeAspect() {
            return new MyBeforeAspect();
        }
    }
}
