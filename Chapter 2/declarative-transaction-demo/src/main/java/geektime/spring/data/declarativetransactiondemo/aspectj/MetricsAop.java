package geektime.spring.data.declarativetransactiondemo.aspectj;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author: fengxuan
 * @create 2019-08-31 01:16
 **/
@Component
@Aspect
@Slf4j
public class MetricsAop {

    //@DeclareParents() 可以给复杂的类添加一个统一的方法，类似abstract method
    //@DeclareParents(value = "geektime.spring.data.declarativetransactiondemo.aspectj.person.Person+",
    //defaultImpl = AdvicedServiceImpl.class)
    //AdvicedService advicedService;


    @Pointcut("execution(* geektime.spring.data.declarativetransactiondemo.aspectj..*(..))")
    public void pointCut1() {

    }


    //@Pointcut("@annotation(geektime.spring.data.declarativetransactiondemo.aspectj.RedisUpdate)")
    //@Pointcut("within(geektime.spring.data.declarativetransactiondemo.aspectj.AdvicedServiceImpl)")
    @Pointcut("@within(geektime.spring.data.declarativetransactiondemo.aspectj.RedisUpdate)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void beforeHandle(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        StringBuffer paramString = new StringBuffer();
        paramString.append(joinPoint.getSignature().toString()).append("####");
        if (!Objects.isNull(args)) {
            for (Object arg : args) {
                paramString.append(JSON.toJSONString(arg)).append("###");
            }
        }
        log.info("param:{}", args);
        log.info("info:{}", paramString);
    }

    @AfterReturning("pointCut()")
    public void afterHandler() {
        log.info("afterReturning");
    }


    @Around("pointCut()")
    public Object handle(ProceedingJoinPoint point) {
        Object proceed = null;
        try {
            long start = System.currentTimeMillis();
            proceed = point.proceed();
            long after = System.currentTimeMillis();
            log.info("cost Time:{}", (after - start));
        } catch (Throwable throwable) {
            log.error("someThing wrong");
            new Throwable(throwable);
        }
        return proceed;
    }
}
