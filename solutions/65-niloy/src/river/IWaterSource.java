package river;

import shape.Point;

public interface IWaterSource {
    void load(Point point);
    void draw();
    void releaseCanvas();
    void getCanvas();
}
