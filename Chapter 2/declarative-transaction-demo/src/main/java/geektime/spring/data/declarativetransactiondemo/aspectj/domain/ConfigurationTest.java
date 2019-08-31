package geektime.spring.data.declarativetransactiondemo.aspectj.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: fengxuan
 * @create 2019-08-31 16:38
 **/
@Slf4j
@Configuration
public class ConfigurationTest {

    @Bean
    public FirstSimpleBean firstSimpleBean() {
        return new FirstSimpleBean();
    }

    @Bean
    public FirstSimpleBeanConsumer firstSimpleBeanConsumer() {
        FirstSimpleBean firstSimpleBean = firstSimpleBean();
        log.info("configurationTest firstSimpleBean:{}", firstSimpleBean);
        return new FirstSimpleBeanConsumer(firstSimpleBean());
    }
}
