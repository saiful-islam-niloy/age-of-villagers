package test;

import org.junit.jupiter.api.Test;
import shape.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BangladeshiFarmersHouse {
    @Test
    public void houseDraw(){
        house.BangladeshiFarmersHouse house = new house.BangladeshiFarmersHouse();
        assertEquals(true, house.draw());
    }

    @Test
    public void houseLoadOnCanvas(){
        house.BangladeshiFarmersHouse house = new house.BangladeshiFarmersHouse();
        assertEquals(true, house.load(new Point(2,2)));
    }
}
