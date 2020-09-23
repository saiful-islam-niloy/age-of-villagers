package river;

import shape.Point;

public class NullRiver implements IWaterSource {
    @Override
    public boolean load(Point point) {
        System.out.println("No river exists!");
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
