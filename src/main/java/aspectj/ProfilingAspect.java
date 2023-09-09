package aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ProfilingAspect {

    @Pointcut(value = "execution(* aspectj.model.*.*(..))")
    public void modelLayer() {

    }

    @Around("modelLayer()")
    public Object logProfile(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        System.out.println("[ProfilingAspect]方法: 【" + proceedingJoinPoint.getSignature() + "】结束，用时: "
                + (System.currentTimeMillis() - start));
        return result;
    }
}
