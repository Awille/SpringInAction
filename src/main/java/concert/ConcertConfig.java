package concert;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configurable
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConcertConfig {
    @Bean("jayChowPerformance")
    public Performance jayChowPerformance() {
        return new JayConcert();
    }
    @Bean("performAspect")
    public Audience audience() {
        return new Audience();
    }
}
