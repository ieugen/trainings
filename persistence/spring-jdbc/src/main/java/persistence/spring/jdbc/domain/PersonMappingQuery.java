package persistence.spring.jdbc.domain;

import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class PersonMappingQuery extends MappingSqlQuery<Person> {

    public PersonMappingQuery(DataSource ds) {
        super(ds, "select id, name, age from person where id = ?");
        super.declareParameter(new SqlInOutParameter("id", Types.INTEGER));
        compile();
    }

    @Override
    protected Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();

        person.setId(rs.getInt("id"));
        person.setAge(rs.getInt("age"));
        person.setName(rs.getString("name"));

        return person;
    }
}
