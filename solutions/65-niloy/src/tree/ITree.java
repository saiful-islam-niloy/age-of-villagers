package tree;

import shape.Point;

public interface ITree {
    boolean load(Point point);
    boolean draw();
    void releaseCanvas();
    void getCanvas();
}
