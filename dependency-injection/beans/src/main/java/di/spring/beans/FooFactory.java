package di.spring.beans;

import di.spring.beans.lifecycle.Bar;
import di.spring.beans.lifecycle.FooCustomMethods;

public class FooFactory {

    private FooCustomMethods fooCustomMethods = new FooCustomMethods();

    public static FooCustomMethods makeFoo(Bar bar) {
        FooCustomMethods fooCustomMethods1 = new FooCustomMethods();
        fooCustomMethods1.setBar(bar);
        return fooCustomMethods1;
    }

    public FooCustomMethods makeFoo() {
        return fooCustomMethods;
    }
}
