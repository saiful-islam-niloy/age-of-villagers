package river;

import shape.Point;

public interface IWaterSource {
    void draw(Point point);
    void canvasController();
    void releaseCanvas();
    void getCanvas();
}
