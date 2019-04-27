package wiringbean.display;

import org.springframework.stereotype.Component;

@Component("iceCream")
public class IceCream implements Dessert{

    public String getDessertName() {
        return "IceCream";
    }
}



