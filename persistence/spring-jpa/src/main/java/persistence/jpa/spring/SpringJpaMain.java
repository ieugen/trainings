package persistence.jpa.spring;

import org.h2.jdbcx.JdbcDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import persistence.jpa.spring.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

public class SpringJpaMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.registerShutdownHook();

        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(Person.builder().age(39).name("Monica").build());
        em.persist(Person.builder().age(12).name("Alex").build());
        em.persist(Person.builder().age(17).name("Zolo").build());
        em.getTransaction().commit();

        System.out.println(em.createNamedQuery("Person.listAll").getResultList());

        em.close();

    }

    @Configuration
//     do we need to enable this if we use EntityManager.getTransaction() ?!?
//    @EnableTransactionManagement
    public static class Config {

        @Bean
        public DataSource dataSource() {
            JdbcDataSource dataSource = new JdbcDataSource();
            dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
            dataSource.setUser("sa");
            dataSource.setPassword("");
            return dataSource;
        }

        @Bean
        public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
            LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();

            emfb.setDataSource(dataSource());
            emfb.setPersistenceProvider(new HibernatePersistenceProvider());
            emfb.setPersistenceUnitName("jpa.spring");
            emfb.afterPropertiesSet();

            return emfb;
        }

        @Bean
        public PlatformTransactionManager transactionManager() {
            return new JpaTransactionManager(entityManagerFactoryBean().getObject());
        }

    }
}
