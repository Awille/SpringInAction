package wiringbean.soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationTest {
    public static void main(String[] args) {
        //java配置类装填
        //ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        //xml文件装填
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        SgtPeppers sgtPeppers = context.getBean(SgtPeppers.class);
        sgtPeppers.play();
    }
}
