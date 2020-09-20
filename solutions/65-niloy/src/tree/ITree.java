package tree;

import shape.Point;

public interface ITree {
    void draw(Point point);
    void canvasController();
    void releaseCanvas();
    void getCanvas();
}
