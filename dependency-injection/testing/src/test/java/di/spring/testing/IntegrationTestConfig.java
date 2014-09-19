package di.spring.testing;

import di.spring.testing.model.DevBar;
import di.spring.testing.model.IBar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class IntegrationTestConfig {

    @Bean
    @Profile("dev")
    public IBar iBar() {
        return new DevBar();
    }

    @Bean
    @Profile("staging")
    public IBar iBarStaging() {
        return new DevBar();
    }
}
