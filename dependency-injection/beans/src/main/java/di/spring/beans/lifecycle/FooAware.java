package di.spring.beans.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class FooAware implements Foo, ApplicationContextAware, BeanNameAware {


    public FooAware() {
        System.out.println(getClass().getSimpleName() + " created");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(getClass().getSimpleName() + " setApplicationContext called");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(getClass().getSimpleName() + " setBeanName called");
    }
}
