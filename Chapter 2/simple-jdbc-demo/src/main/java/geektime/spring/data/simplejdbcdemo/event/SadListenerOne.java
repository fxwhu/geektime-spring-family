package geektime.spring.data.simplejdbcdemo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * @author: fengxuan
 * @create 2019-09-01 10:23
 **/
@Component
@Slf4j
public class SadListenerOne {

    @EventListener
    @Order(1)
    public void receiveSadEvent(SadEvent sadEvent) {
        log.info("sadListenerOne:{}", sadEvent);
    }
}
