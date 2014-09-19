package di.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBeforeAspect {

    // intercept the execution of any Foo,methodCall() method
    @Before("execution(public * di.spring.aop.Foo.methodCall(..))")
    public void allMethodCalls(JoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        System.out.println("We are doing AOP. Params are:" + args[0] + "," + args[1]);
    }
}
