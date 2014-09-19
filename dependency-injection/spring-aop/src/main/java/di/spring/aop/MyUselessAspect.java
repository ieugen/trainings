package di.spring.aop;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyUselessAspect {

    public MyUselessAspect() {
        System.out.println(getClass().getSimpleName() + " created");
    }
}
