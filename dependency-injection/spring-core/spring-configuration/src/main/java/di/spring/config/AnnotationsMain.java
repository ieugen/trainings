package di.spring.config;

import di.spring.config.annotations.Foo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsMain {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("annotations/foo-annotations.xml");
        Foo foo = (Foo) context.getBean("foo");

        System.out.println(foo.makeSomeFoo());

    }
}
