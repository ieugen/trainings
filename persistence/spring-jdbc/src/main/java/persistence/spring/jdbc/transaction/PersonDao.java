package persistence.spring.jdbc.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import persistence.spring.jdbc.domain.Person;
import persistence.spring.jdbc.domain.PersonMapper;

import java.util.List;

@Transactional
public class PersonDao {

    @Autowired
    private JdbcTemplate template;

    public PersonDao(JdbcTemplate template) {
        this.template = template;
    }

    @Transactional("dataSourceTransactionManager")
    public void save(Person person) {
        template.update("insert into person(name, age) values (?,?)", person.getName(), person.getAge());
        template.update("insert into person(name, age) values (?,?)", person.getName(), person.getAge());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Person> list() {
        return template.query("select * from person", new PersonMapper());
    }

}
