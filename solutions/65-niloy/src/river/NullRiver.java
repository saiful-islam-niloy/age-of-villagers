package river;

import shape.Point;

public class NullRiver implements IWaterSource {
    @Override
    public void draw(Point point) {
        System.out.println("No river exists!");
    }

    @Override
    public void canvasController() {

    }

    @Override
    public void releaseCanvas() {

    }

    @Override
    public void getCanvas() {

    }
}
