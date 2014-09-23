package di.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBeforeAspect {

    // intercept the execution of any Foo,methodCall() method
    @Before("execution(* di.spring.aop.Foo.*(..))")
    public void allMethodCalls(JoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        String result = (args.length != 0) ? args[0] + "," + args[1] : "no args";

        System.out.println("We are doing AOP. Params are:" + result);
    }
}
