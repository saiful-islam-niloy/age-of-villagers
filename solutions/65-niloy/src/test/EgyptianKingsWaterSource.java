package test;

import org.junit.jupiter.api.Test;
import shape.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EgyptianKingsWaterSource {
    @Test
    public void waterResourceDraw(){
        river.EgyptianKingsWaterSource river = new river.EgyptianKingsWaterSource();
        river.getCanvas();
        assertEquals(true, river.draw());
        river.releaseCanvas();
    }

    @Test
    public void waterResourceLoadOnCanvas(){
        river.EgyptianKingsWaterSource river = new river.EgyptianKingsWaterSource();
        river.getCanvas();
        assertEquals(true, river.load(new Point(50,50)));
        river.releaseCanvas();
    }
}
