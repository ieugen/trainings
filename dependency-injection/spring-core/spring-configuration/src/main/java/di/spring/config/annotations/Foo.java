package di.spring.config.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "aaaa")
public class Foo {

    private Bar bar;
    private Baz baz;

    @Autowired
    public Foo(Bar bar, Baz baz) {
        this.bar = bar;
        this.baz = baz;
    }

    public String makeSomeFoo() {
        return bar.toString() + baz.toString();
    }
}
