package geektime.spring.data.simplejdbcdemo.configuratabletest;

import lombok.*;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @author: fengxuan
 * @create 2019-08-31 21:43
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
    private int id;
    private String name;
}
