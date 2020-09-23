package test;

import org.junit.jupiter.api.Test;
import shape.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BangladeshiFarmersWaterSource {
    @Test
    public void waterResourceDraw(){
        river.BangladeshiFarmersWaterSource river = new river.BangladeshiFarmersWaterSource();
        assertEquals(true, river.draw());
    }

    @Test
    public void waterResourceLoadOnCanvas(){
        river.BangladeshiFarmersWaterSource river = new river.BangladeshiFarmersWaterSource();
        assertEquals(true, river.load(new Point(2,2)));
    }
}
