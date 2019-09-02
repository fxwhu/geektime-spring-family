package geektime.spring.data.simplejdbcdemo.event;

import lombok.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;

/**
 * @author: fengxuan
 * @create 2019-09-01 09:56
 **/
@Getter
@Setter
public class SadEvent extends ApplicationEvent {
    private String patient;

    private String advisor;

    public SadEvent(Object source, String patient, String advisor) {
        super(source);
        this.patient = patient;
        this.advisor = advisor;
    }
}
