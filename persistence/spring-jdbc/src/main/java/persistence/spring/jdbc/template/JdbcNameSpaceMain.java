package persistence.spring.jdbc.template;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcNameSpaceMain {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdbc-namespace.xml");
        context.registerShutdownHook();

        DataSource dataSource = context.getBean(DataSource.class);

        JdbcTemplate template = new JdbcTemplate(dataSource);
        // manually call afterPropertiesSet() for all non beans
        template.afterPropertiesSet();

        int count = template.queryForObject("select count(*) from person", Integer.class);
        System.out.println("We found " + count + " records in table persons");
    }
}
