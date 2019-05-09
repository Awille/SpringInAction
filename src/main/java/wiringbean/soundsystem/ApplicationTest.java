package wiringbean.soundsystem;

import concert.ConcertConfig;
import concert.JayConcert;
import concert.Performance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationTest {
    public static void main(String[] args) {
        //java配置类装填
        ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class,
                ConcertConfig.class);
        //xml文件装填
        //ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/spring-config.xml");
        //System.out.println("classpath: " + Thread.currentThread().getContextClassLoader().getResource("").getPath());
//        SgtPeppers sgtPeppers = context.getBean(SgtPeppers.class);
//        sgtPeppers.play();
//        MediaPlayer mediaPlayer = context.getBean("cdPlayer", MediaPlayer.class);
//        mediaPlayer.play();
        Performance jayConcert = context.getBean("jayChowPerformance", JayConcert.class);
        jayConcert.perform();

    }
}
