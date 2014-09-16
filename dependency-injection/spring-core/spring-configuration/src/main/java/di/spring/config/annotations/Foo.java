package di.spring.config.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "aaaa")
//@Named("aaaa")
public class Foo {

    private Bar bar;
    private Baz baz;

    @Autowired
//    @Inject
    public Foo(Bar bar, Baz baz) {
        this.bar = bar;
        this.baz = baz;
    }

    public String makeSomeFoo() {
        return bar.toString() + baz.toString();
    }
}
