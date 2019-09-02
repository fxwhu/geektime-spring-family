package geektime.spring.data.simplejdbcdemo.configuratabletest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;

/**
 * @author: fengxuan
 * @create 2019-08-31 21:45
 **/
@Configuration
public class ItemConfiguration {

    //@Bean
    //public InstrumentationLoadTimeWeaver loadTimeWeaver() throws Throwable {
    //    InstrumentationLoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
    //    return loadTimeWeaver;
    //}

    @Bean
    public Dog getDog() {
        return new Dog(1, "dog");
    }
}
