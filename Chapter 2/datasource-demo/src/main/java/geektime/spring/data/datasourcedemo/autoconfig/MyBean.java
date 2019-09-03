package geektime.spring.data.datasourcedemo.autoconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: fengxuan
 * @create 2019-09-03 10:17
 **/
@Component
@Slf4j
public class MyBean {

    @Autowired
    private ApplicationArguments applicationArguments;

    public void logApplicationArgs() {
        boolean debug = applicationArguments.containsOption("debug");
        List<String> nonOptionArgs = applicationArguments.getNonOptionArgs();
        log.info("debug:{}, nonOptionArgs:{}", debug, nonOptionArgs);
    }
}
