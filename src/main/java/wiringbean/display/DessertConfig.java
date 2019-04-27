package wiringbean.display;

import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
public class DessertConfig {
    @Bean
    public Dessert cake() {
        return new Cake();
    }

    @Bean
    public Dessert cookie() {
        return new Cookie();
    }

    @Bean
    public Dessert iceCream() {
        return new IceCream();
    }

    @Bean
    public TasteDessert tasteDessert() {
        return new TasteDessert();
    }
}
