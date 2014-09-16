package di.spring.beans.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifecycleMain {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanLifecycleConfig.class);
        Foo foo = context.getBean(Foo.class);

    }

    @Configuration
    public static class BeanLifecycleConfig {

        @Bean
        public Foo foo() {
            return new Foo();
        }
    }
}
