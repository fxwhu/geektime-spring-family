package geektime.spring.data.declarativetransactiondemo.aspectj;

import java.util.List;

/**
 * @author: fengxuan
 * @create 2019-08-31 01:08
 **/
public interface AdvicedService {

    int doCountBySomeCondition(String condition1, List<String> conditions);

    void insert(String param1, Integer param2);
}
