package persistence.jpa;

import persistence.jpa.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JpaStandard {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa.standard");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(Person.builder().age(39).name("Monica").build());
        entityManager.persist(Person.builder().age(12).name("Alex").build());
        entityManager.persist(Person.builder().age(17).name("Zolo").build());

        entityManager.getTransaction().commit();

        List<Person> enitites = entityManager.createQuery("select p from Person p", Person.class).getResultList();
        System.out.println("We have found " + enitites);
        List<Person> list = entityManager.createNamedQuery("Person.listAll").getResultList();

        System.out.println("Using named query " + list);

        entityManager.close();
        entityManagerFactory.close();
    }
}
