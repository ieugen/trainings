package di.spring.config.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Foo foo() {
        return new Foo(new Bar(), baz());
    }

    @Bean
    public Baz baz() {
        return new Baz();
    }
}
