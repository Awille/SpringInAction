package wiringbean.display;

import org.springframework.stereotype.Component;

@Component("cookie")
public class Cookie implements Dessert {
    public String getDessertName() {
        return "Cookie";
    }
}
