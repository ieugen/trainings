package di.spring.config;

import di.spring.config.multiple.FooFoo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MultipleConfigsXmlMain {

    public static void main(String[] args) {
//        An alternative to loading a Spring XML config that uses imports is to load multiple XML files
// http://docs.spring.io/spring/docs/current/spring-framework-reference/html/beans.html#beans-factory-xml-import

        ApplicationContext context = new ClassPathXmlApplicationContext("multiple/foo-foo.xml");
        FooFoo fooFoo = context.getBean(FooFoo.class);

        fooFoo.makeMoreFoo();

//        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{
//                "annotations/foo-annotations.xml",
//                "multiple/foo-java.xml",
//                "multiple/just-foo-foo.xml"
//        });

    }
}
