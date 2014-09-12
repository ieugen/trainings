package ieugen.trainings.di.spring;

import ieugen.trainings.di.notebook.api.Computer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NoteBookApp {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring-di.xml");

        Computer modern = context.getBean(Computer.class);
        modern.boot();
    }
}
