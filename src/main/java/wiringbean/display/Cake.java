package wiringbean.display;

import org.springframework.stereotype.Component;

@Component("cake")
public class Cake implements Dessert {
    public String getDessertName() {
        return "Cake";
    }
}
