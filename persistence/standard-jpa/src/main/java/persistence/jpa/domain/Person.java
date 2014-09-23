package persistence.jpa.domain;

import lombok.Data;
import lombok.experimental.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Data
@Builder
@NamedQueries({
        @NamedQuery(name = "Person.listAll", query = "select pers from Person pers")
})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int age;

}
