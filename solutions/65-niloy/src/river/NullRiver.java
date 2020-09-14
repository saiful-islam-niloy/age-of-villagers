package river;

public class NullRiver implements IWaterSource {
    @Override
    public void draw() {
        System.out.println("No river exists!");
    }

    @Override
    public void releaseCanvas() {

    }

    @Override
    public void getCanvas() {

    }
}
