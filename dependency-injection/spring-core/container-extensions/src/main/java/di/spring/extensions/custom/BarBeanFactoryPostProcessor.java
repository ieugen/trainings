package di.spring.extensions.custom;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BarBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private int aValue;

    public BarBeanFactoryPostProcessor(int aValue) {
        this.aValue = aValue;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // change all Bar's A property to value 10

        String[] beans = beanFactory.getBeanDefinitionNames();

        for (String name : beans) {
            Class<?> beanType = beanFactory.getType(name);

            if (Bar.class.isAssignableFrom(beanType)) {
                BeanDefinition barDef = beanFactory.getBeanDefinition(name);
                MutablePropertyValues propertyValues = barDef.getPropertyValues();

                propertyValues.addPropertyValue("a", aValue);
            }
        }
    }

}
