package river;

import shape.Point;

public class NullRiver implements IWaterSource {
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
