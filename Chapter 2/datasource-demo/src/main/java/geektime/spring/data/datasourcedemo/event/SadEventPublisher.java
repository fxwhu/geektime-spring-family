package geektime.spring.data.datasourcedemo.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author: fengxuan
 * @create 2019-09-01 10:01
 **/
@Component
public class SadEventPublisher implements ApplicationEventPublisherAware {


    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void sendSadMessage() {
        SadEvent sadEvent = new SadEvent(this, "patient", "advisor");
        publisher.publishEvent(sadEvent);
    }


    public void sendContextStartEvent() {
        ContextStartedEvent contextStartedEvent = new ContextStartedEvent(this, "contextStart");
        publisher.publishEvent(contextStartedEvent);
    }
}
