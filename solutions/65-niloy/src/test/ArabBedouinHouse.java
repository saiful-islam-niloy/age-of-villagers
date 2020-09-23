package test;

import org.junit.jupiter.api.Test;
import shape.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArabBedouinHouse {
    @Test
    public void houseDraw(){
        house.ArabBedouinHouse house = new house.ArabBedouinHouse();
        assertEquals(true, house.draw());
    }

    @Test
    public void houseLoadOnCanvas(){
        house.ArabBedouinHouse house = new house.ArabBedouinHouse();
        assertEquals(true, house.load(new Point(2,2)));
    }
}
