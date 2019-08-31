package geektime.spring.data.declarativetransactiondemo.aspectj;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: fengxuan
 * @create 2019-08-31 01:09
 **/
@RedisUpdate(key = "redisKey")
@Component
public class AdvicedServiceImpl implements AdvicedService {
    @Override
    public int doCountBySomeCondition(String condition1, List<String> conditions) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    //@RedisUpdate(key = "redisKey")
    public void insert(String param1, Integer param2) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
