package tree;

import shape.Point;

public class NullTree implements ITree {
    @Override
    public void load(Point point) {
        System.out.println("No tree exists!");
    }

    @Override
    public void draw() {

    }

    @Override
    public void releaseCanvas() {

    }

    @Override
    public void getCanvas() {

    }
}
