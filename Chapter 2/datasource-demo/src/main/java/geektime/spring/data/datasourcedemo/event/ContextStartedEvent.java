package geektime.spring.data.datasourcedemo.event;

import lombok.*;
import org.springframework.context.ApplicationEvent;

/**
 * @author: fengxuan
 * @create 2019-09-01 12:24
 **/
@Setter
@Getter
@ToString
public class ContextStartedEvent extends ApplicationEvent {

    private String name;

    public ContextStartedEvent(Object source, String name) {
        super(source);
        this.name = name;
    }
}
