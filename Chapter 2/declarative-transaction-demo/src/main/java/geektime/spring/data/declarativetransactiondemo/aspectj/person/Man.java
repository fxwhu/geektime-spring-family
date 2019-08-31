package geektime.spring.data.declarativetransactiondemo.aspectj.person;

import org.springframework.stereotype.Component;

/**
 * @author: fengxuan
 * @create 2019-08-31 16:07
 **/
@Component
public class Man implements Person{
    @Override
    public String eat() {
        return "eat something";
    }
}
