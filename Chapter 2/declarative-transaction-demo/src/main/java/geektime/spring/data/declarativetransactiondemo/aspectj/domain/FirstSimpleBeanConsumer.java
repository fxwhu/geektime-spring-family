package geektime.spring.data.declarativetransactiondemo.aspectj.domain;

/**
 * @author: fengxuan
 * @create 2019-08-31 16:37
 **/
public class FirstSimpleBeanConsumer {

    private FirstSimpleBean firstSimpleBean;

    public FirstSimpleBeanConsumer(FirstSimpleBean firstSimpleBean) {
        this.firstSimpleBean = firstSimpleBean;
    }
}
