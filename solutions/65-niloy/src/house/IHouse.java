package house;

import shape.Point;

public interface IHouse {
    void load(Point point);

    void draw();

    void releaseCanvas();

    void getCanvas();
}
