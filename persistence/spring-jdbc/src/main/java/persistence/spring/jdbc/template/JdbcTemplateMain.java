package persistence.spring.jdbc.template;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import persistence.spring.jdbc.domain.Person;
import persistence.spring.jdbc.domain.PersonMapper;

import java.util.List;

public class JdbcTemplateMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.registerShutdownHook();

        JdbcTemplate template = context.getBean(JdbcTemplate.class);

        template.execute("create table person(id integer , name char(100), age integer)");

        template.update("insert into person(id, name, age) values(?,?,?)", 1, "Ioan", 23);
        template.update("insert into person(id, name, age) values(?,?,?)", 2, "Ana", 26);
        template.update("insert into person(id, name, age) values(?,?,?)", 3, "Maria", 19);

        List<Person> persons = template.query("select * from person", new PersonMapper());

        System.out.println(persons);
    }

}
