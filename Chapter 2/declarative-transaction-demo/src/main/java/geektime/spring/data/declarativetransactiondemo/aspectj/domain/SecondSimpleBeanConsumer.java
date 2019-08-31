package geektime.spring.data.declarativetransactiondemo.aspectj.domain;

/**
 * @author: fengxuan
 * @create 2019-08-31 16:38
 **/
public class SecondSimpleBeanConsumer {
    private SecondSimpleBean secondSimpleBean;

    public SecondSimpleBeanConsumer(SecondSimpleBean secondSimpleBean) {
        this.secondSimpleBean = secondSimpleBean;
    }
}
