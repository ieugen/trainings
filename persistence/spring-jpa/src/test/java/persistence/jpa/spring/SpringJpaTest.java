package persistence.jpa.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import persistence.jpa.spring.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class SpringJpaTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test
    @Rollback
    public void testPersistPerson() throws Exception {
        List<Person> personList = entityManager.createNamedQuery("Person.listAll").getResultList();
        System.out.println(personList);

        assertThat(personList.size(), is(2));
        entityManager.persist(Person.builder().age(34).name("Lala").build());
    }

    @Test
    @Rollback
    public void testPersistPerson2() throws Exception {
        List<Person> personList = entityManager.createNamedQuery("Person.listAll").getResultList();
        System.out.println(personList);

        assertThat(personList.size(), is(2));
    }
}