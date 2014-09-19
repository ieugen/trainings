package di.spring.testing;

import di.spring.testing.model.Foo;
import di.spring.testing.model.IBar;
import di.spring.testing.model.ProductionBarImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    public Foo bar(IBar iBar) {
        return new Foo(iBar);
    }

    @Bean
    @Profile("prod")
    public IBar iBar() {
        return new ProductionBarImpl();
    }

}
