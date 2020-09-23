package test;

import org.junit.jupiter.api.Test;
import shape.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InuitHuntersHouse {
    @Test
    public void houseDraw(){
        house.InuitHuntersHouse house = new house.InuitHuntersHouse();
        assertEquals(true, house.draw());
    }

    @Test
    public void houseLoadOnCanvas(){
        house.InuitHuntersHouse house = new house.InuitHuntersHouse();
        assertEquals(true, house.load(new Point(2,2)));
    }
}
