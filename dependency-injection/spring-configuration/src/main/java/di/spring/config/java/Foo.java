package di.spring.config.java;

public class Foo {

    private Bar bar;
    private Baz baz;

    public Foo(Bar bar, Baz baz) {
        this.bar = bar;
        this.baz = baz;
    }

    public String makeSomeFoo() {
        return bar.toString() + baz.toString();
    }

}
