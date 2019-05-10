package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

    @Pointcut("execution(* concert.Performance.perform(..))")
    public void performance() {

    }

    //该注解内就是一个切面表达式
    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silence Cell Phones");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Take Seats");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demand Refund");
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("Before Concert");
            joinPoint.proceed();
            System.out.println("After Concert");
        } catch (Throwable e) {
            System.out.println("Demanding Refund");
        }

    }



}
