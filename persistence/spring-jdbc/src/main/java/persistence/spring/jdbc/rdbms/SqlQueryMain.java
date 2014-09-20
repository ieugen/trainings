package persistence.spring.jdbc.rdbms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.object.SqlQuery;
import persistence.spring.jdbc.domain.Person;
import persistence.spring.jdbc.domain.PersonMappingQuery;
import persistence.spring.jdbc.template.AppConfig;

public class SqlQueryMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.registerShutdownHook();

        SqlQuery<Person> query = context.getBean(PersonMappingQuery.class);

        Person person = query.findObject(1);
        System.out.println(person);
    }

    @Configuration
    @Import(AppConfig.class)
    public static class Config {

        @Bean(destroyMethod = "shutdown")
        public EmbeddedDatabase dataSource() {
            return new EmbeddedDatabaseBuilder()
                    .addScript("db_init.sql")
                    .setType(EmbeddedDatabaseType.H2)
                    .build();
        }

        @Bean
        public PersonMappingQuery personMappingQuery() {
            return new PersonMappingQuery(dataSource());
        }

    }
}
