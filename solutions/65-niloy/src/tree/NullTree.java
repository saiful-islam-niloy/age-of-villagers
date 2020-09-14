package tree;

public class NullTree implements ITree {
    @Override
    public void draw() {
        System.out.println("No tree exists!");
    }

    @Override
    public void releaseCanvas() {

    }

    @Override
    public void getCanvas() {

    }
}
