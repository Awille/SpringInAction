package wiringbean.soundsystem;

import jdk.internal.util.EnvUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationTest {
    public static void main(String[] args) {
        //java配置类装填
        //ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        //xml文件装填
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/spring-config.xml");
        //System.out.println("classpath: " + Thread.currentThread().getContextClassLoader().getResource("").getPath());
//        SgtPeppers sgtPeppers = context.getBean(SgtPeppers.class);
//        sgtPeppers.play();
        MediaPlayer mediaPlayer = context.getBean("cdPlayer", MediaPlayer.class);
        mediaPlayer.play();

    }
}
