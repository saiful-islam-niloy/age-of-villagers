package tree;

import shape.Point;

public interface ITree {
    void load(Point point);
    void draw();
    void releaseCanvas();
    void getCanvas();
}
