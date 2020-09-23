package tree;

import shape.Point;

public class NullTree implements ITree {
    @Override
    public boolean load(Point point) {
        return true;
    }

    @Override
    public boolean draw() {
        return true;
    }

    @Override
    public void releaseCanvas() {

    }

    @Override
    public void getCanvas() {

    }
}
