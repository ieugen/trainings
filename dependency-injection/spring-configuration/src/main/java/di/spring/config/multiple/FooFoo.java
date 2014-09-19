package di.spring.config.multiple;

import di.spring.config.java.Foo;

public class FooFoo {

    private Foo javaFoo;
    private di.spring.config.annotations.Foo annotationFoo;

    public FooFoo(di.spring.config.annotations.Foo annotationFoo) {
        this.annotationFoo = annotationFoo;
    }

    public String makeMoreFoo() {
        String result = javaFoo.makeSomeFoo() + annotationFoo.makeSomeFoo();
        System.out.println(result);
        return result;
    }

    public Foo getJavaFoo() {
        return javaFoo;
    }

    public void setJavaFoo(Foo javaFoo) {
        this.javaFoo = javaFoo;
    }
}
