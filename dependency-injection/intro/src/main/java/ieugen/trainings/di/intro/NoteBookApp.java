package ieugen.trainings.di.intro;

import ieugen.trainings.di.intro.impl.NoteBook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NoteBookApp {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/spring-di.xml");

        NoteBook modern = context.getBean(NoteBook.class);
        modern.boot();
    }
}
