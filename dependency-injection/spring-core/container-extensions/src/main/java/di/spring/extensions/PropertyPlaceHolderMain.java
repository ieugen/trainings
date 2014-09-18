package di.spring.extensions;

import di.spring.extensions.custom.Bar;
import di.spring.extensions.custom.IBar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class PropertyPlaceHolderMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("property-placeholder.xml");

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        context.registerShutdownHook();

        Bar bar = context.getBean("bar", Bar.class);
        bar.printIt();

        IBar ibar = (IBar) context.getBean("iBar");
        ibar.printIt();
    }

    // Property placeholder replacement with Java Config
    @Configuration
    public static class Config {

        @Bean
        public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
            PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
            configurer.setLocation(new ClassPathResource("staging.properties"));
            return configurer;
        }

        @Bean
        public IBar iBar(@Value("${ibar.class}") String clazz)
                throws ClassNotFoundException, IllegalAccessException, InstantiationException {

            Class<IBar> ibar = (Class<IBar>) Class.forName(clazz);
            return ibar.newInstance();
        }

        @Bean
        public Bar bar(@Value("${bar.property_a}") int a) {
            return new Bar(a);
        }

    }

}
