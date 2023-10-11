package spring.transaction;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TxAspect {

    @Pointcut("execution(public * spring.transaction..*.*(..))")
    private void pointcut() {

    }

    @Around("pointcut()")
    public Object around(JoinPoint joinPoint) throws Throwable {
        // 在方法执行前开启事务
        TransactionUtil.startTransaction();
        Object proceed = null;
        try {
            ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) joinPoint;
            proceed = proceedingJoinPoint.proceed();
        } catch (Throwable t) {
            // 出现异常进行回滚
            TransactionUtil.rollback();
            return proceed;
        }
        // 方法执行完成后提交事务
        TransactionUtil.commit();
        return proceed;
    }
}
