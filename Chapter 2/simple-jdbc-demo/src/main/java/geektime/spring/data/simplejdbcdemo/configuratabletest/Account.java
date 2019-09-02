package geektime.spring.data.simplejdbcdemo.configuratabletest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @author: fengxuan
 * @create 2019-08-31 21:44
 **/
@Slf4j
@Configurable
public class Account {
    @Autowired
    private Dog dog;

    public void outPrint() {
        log.info("dog:{}", dog.toString());
    }
}
