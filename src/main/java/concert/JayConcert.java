package concert;

import org.springframework.stereotype.Component;

@Component
public class JayConcert implements Performance {
    public void perform() {
        System.out.println("Herllo, I am Jay, Here is my new song 借口");
    }
}
