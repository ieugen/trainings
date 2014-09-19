package di.spring.beans.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class FooInitAndDisposable implements Foo, InitializingBean, DisposableBean {


    public FooInitAndDisposable() {
        System.out.println(getClass().getSimpleName() + " created");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(getClass().getSimpleName() + " init method called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(getClass().getSimpleName() + " destroy method called");
    }

}
