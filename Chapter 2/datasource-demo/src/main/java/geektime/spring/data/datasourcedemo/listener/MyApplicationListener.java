package geektime.spring.data.datasourcedemo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author: fengxuan
 * @create 2019-09-02 23:36
 **/
@Slf4j
public class MyApplicationListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationStartingEvent) {
            System.out.println("ApplicationStartingEvent listener" + event);
            log.info("ApplicationStartingEvent listener:{}", event);
        }
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            System.out.println("ApplicationEnvironmentPreparedEvent listener" + event);
            log.info("ApplicationEnvironmentPreparedEvent listener:{}", event);
        }
        if (event instanceof ApplicationPreparedEvent) {
            System.out.println("ApplicationPreparedEvent listener" + event);
            log.info("ApplicationPreparedEvent listener:{}", event);
        }
        if (event instanceof ApplicationStartedEvent) {
            System.out.println("ApplicationStartedEvent listener" + event);
            log.info("ApplicationStartedEvent listener:{}", event);
        }
        if (event instanceof ApplicationReadyEvent) {
            System.out.println("ApplicationReadyEvent listener" + event);
            log.info("ApplicationReadyEvent listener:{}", event);
        }
        if (event instanceof ApplicationFailedEvent) {
            System.out.println("ApplicationFailedEvent listener" + event);
            log.info("ApplicationFailedEvent listener:{}", event);
        }
    }
}
