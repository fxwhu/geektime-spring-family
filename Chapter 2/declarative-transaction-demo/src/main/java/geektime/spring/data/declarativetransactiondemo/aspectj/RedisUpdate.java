package geektime.spring.data.declarativetransactiondemo.aspectj;

import java.lang.annotation.*;

/**
 * @author: fengxuan
 * @create 2019-08-31 01:11
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface RedisUpdate {
    String key();
    String value() default "";
}
