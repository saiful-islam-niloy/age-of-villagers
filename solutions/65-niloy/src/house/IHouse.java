package house;

import shape.Point;

public interface IHouse {
    boolean load(Point point);

    boolean draw();

    void releaseCanvas();

    void getCanvas();
}
