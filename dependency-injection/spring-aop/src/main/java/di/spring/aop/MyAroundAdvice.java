package di.spring.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAroundAdvice {

    @Around("execution(* di.spring.aop.Foo.methodCall(..))")
    public void loggingAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Înainte de execuția medotdei");
//        pjp.proceed(pjp.getArgs());
        System.out.println("După execuția medotdei");
    }

}
