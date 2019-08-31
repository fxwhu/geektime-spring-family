package geektime.spring.data.declarativetransactiondemo.aspectj.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: fengxuan
 * @create 2019-08-31 16:39
 **/
@Slf4j
@Component
public class ComponentTest {

    @Bean
    public SecondSimpleBean secondSimpleBean() {
        return new SecondSimpleBean();
    }

    @Bean
    public SecondSimpleBeanConsumer secondSimpleBeanConsumer() {
        SecondSimpleBean secondSimpleBean = secondSimpleBean();
        log.info("component secondSimpleBean:{}", secondSimpleBean);
        return new SecondSimpleBeanConsumer(secondSimpleBean());
    }
}
