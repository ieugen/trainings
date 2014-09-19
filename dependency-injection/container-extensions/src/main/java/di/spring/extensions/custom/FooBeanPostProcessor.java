package di.spring.extensions.custom;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class FooBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Foo) {
            System.out.println(" Bean " + beanName + " created :" + bean.toString());
        } else if (bean instanceof Bar) {
            System.out.println("We do not process Bar's ");
        }
        return bean;
    }
}
