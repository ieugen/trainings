package persistence.spring.jdbc.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import persistence.spring.jdbc.domain.Person;
import persistence.spring.jdbc.domain.PersonMapper;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;

public class NamedParameterJdbcTemplateMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.registerShutdownHook();

        NamedParameterJdbcTemplate template = context.getBean(NamedParameterJdbcTemplate.class);

        String query = "select * from person where name = :name";
        SqlParameterSource namedParameters = new MapSqlParameterSource("name", "Andreea");

        List<Person> persons = template.query(query, namedParameters, new PersonMapper());

        System.out.println(persons);

        String countQuery = "select count(*) from person";
        int count = template.queryForObject(countQuery, new HashMap<String, Object>(), Integer.class);

        System.out.println("We have " + count + " persons in the database");
    }

    @Configuration
    @Import(persistence.spring.jdbc.template.AppConfig.class)
    public static class Config {

        @Autowired
        private DataSource dataSource;

        @Bean
        public DataSourceInitializer dataSourceInitializer() {
            DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
            dataSourceInitializer.setDataSource(dataSource);
            DatabasePopulator populator = new ResourceDatabasePopulator(new ClassPathResource("db_init.sql"));

            dataSourceInitializer.setDatabasePopulator(populator);
//            dataSourceInitializer.setEnabled();

            return dataSourceInitializer;
        }

        @Bean
        public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
            NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);

            return template;
        }
    }
}
