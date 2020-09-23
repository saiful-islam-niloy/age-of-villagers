package test;

import org.junit.jupiter.api.Test;
import shape.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EgyptianKingsHouse {
    @Test
    public void houseDraw(){
        house.EgyptianKingsHouse house = new house.EgyptianKingsHouse();
        assertEquals(true, house.draw());
    }

    @Test
    public void houseLoadOnCanvas(){
        house.EgyptianKingsHouse house = new house.EgyptianKingsHouse();
        assertEquals(true, house.load(new Point(2,2)));
    }
}
