package di.spring.config.annotations;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component(value = "aaaa")
//@Named("aaaa")
public class Foo {

    private ApplicationContext applicationContext;
    private Environment environment;

    @Autowired
    private BeanFactory beanFactory;

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

    // will use Auto wiring
    @Required
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Autowired(required = false)
    public Environment getEnvironment() {
        return environment;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
