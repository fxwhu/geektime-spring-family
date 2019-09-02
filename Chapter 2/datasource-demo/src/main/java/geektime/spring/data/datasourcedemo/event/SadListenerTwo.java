package geektime.spring.data.datasourcedemo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: fengxuan
 * @create 2019-09-01 10:26
 **/
@Component
@Slf4j
public class SadListenerTwo {

    @EventListener({SadEvent.class, ContextStartedEvent.class})
    @Order(2)
    public void handleSadEvent(Object event) {
        if (event instanceof SadEvent) {
            log.info("SadListenerTwo, SadEvent:{}", event);
        }
        if (event instanceof ContextStartedEvent) {
            log.info("SadListenerTwo, ContextStartedEvent:{}", event);
        }
    }
}
