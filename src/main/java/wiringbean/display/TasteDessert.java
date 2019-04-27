package wiringbean.display;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TasteDessert {
    private Dessert dessert;

    @Autowired
    @Qualifier("iceCream")
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public void getDessertName() {
        System.out.println(dessert.getDessertName());
    }
}
