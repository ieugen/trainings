package di.spring.beans.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class FooAnnotations implements Foo {

    public FooAnnotations() {
        System.out.println(getClass().getSimpleName() + " created");
    }

    @PostConstruct
    public void myInit() {
        System.out.println(getClass().getSimpleName() + " init method called");
    }

    @PreDestroy
    public void myDestroy() {
        System.out.println(getClass().getSimpleName() + " destroy method called");
    }
}
