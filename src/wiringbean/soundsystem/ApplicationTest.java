package wiringbean.soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        SgtPeppers sgtPeppers = context.getBean(SgtPeppers.class);
        sgtPeppers.play();
    }
}
