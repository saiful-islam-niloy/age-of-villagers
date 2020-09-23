package river;

import shape.Point;

public interface IWaterSource {
    boolean load(Point point);
    boolean draw();
    void releaseCanvas();
    void getCanvas();
}
