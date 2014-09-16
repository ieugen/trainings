package di.spring.beans;

import di.spring.beans.lifecycle.Bar;
import di.spring.beans.lifecycle.Foo;

public class FooFactory {

    private Foo foo = new Foo();

    public static Foo makeFoo(Bar bar) {
        Foo foo1 = new Foo();
        foo1.setBar(bar);
        return foo1;
    }

    public Foo makeFoo() {
        return foo;
    }
}
