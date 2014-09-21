package persistence.spring.jdbc.transaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import persistence.spring.jdbc.domain.Person;
import persistence.spring.jdbc.template.AppConfig;

import javax.sql.DataSource;

public class TransactionalJdbcMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.registerShutdownHook();

        PersonDao dao = context.getBean(PersonDao.class);
        Person person = new Person();
        person.setName("Mikalos");
        person.setAge(31);

        dao.save(person);

        System.out.println(dao.list());

    }

    @Configuration
    @Import(AppConfig.class)
    @EnableTransactionManagement
    public static class Config {

        @Bean
        public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }

        @Bean
        public PersonDao personDao(JdbcTemplate template) {
            return new PersonDao(template);
        }

        @Bean
        public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
            DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
            dataSourceInitializer.setDataSource(dataSource);
            DatabasePopulator populator = new ResourceDatabasePopulator(new ClassPathResource("db_init.sql"));

            dataSourceInitializer.setDatabasePopulator(populator);

            return dataSourceInitializer;
        }

    }

}
