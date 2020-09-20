package house;

import shape.Point;

public interface IHouse {
    void draw(Point point);

    void canvasController();

    void releaseCanvas();

    void getCanvas();
}
