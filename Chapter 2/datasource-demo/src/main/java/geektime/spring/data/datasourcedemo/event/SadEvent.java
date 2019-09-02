package geektime.spring.data.datasourcedemo.event;

import lombok.*;
import org.springframework.context.ApplicationEvent;

/**
 * @author: fengxuan
 * @create 2019-09-01 09:56
 **/
@Getter
@Setter
@ToString
public class SadEvent extends ApplicationEvent {
    private String patient;

    private String advisor;

    public SadEvent(Object source, String patient, String advisor) {
        super(source);
        this.patient = patient;
        this.advisor = advisor;
    }
}
