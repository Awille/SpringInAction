package wiringbean.display;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class DisplayTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DessertConfig.class);
        TasteDessert tasteDessert = context.getBean(TasteDessert.class);
        tasteDessert.getDessertName();
    }
}
