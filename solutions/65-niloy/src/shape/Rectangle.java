package shape;

public class Rectangle implements IShape{
    private Point topLeft;
    private Point bottomRight;
    private Point topRight;
    private Point bottomLeft;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;

        topRight = new Point(bottomRight.x, topLeft.y);
        bottomLeft = new Point(topLeft.x, bottomRight.y);
    }

    @Override
    public void draw() {
        new Line(topLeft, topRight).draw();
        new Line(topRight, bottomRight).draw();
        new Line(bottomRight, bottomLeft).draw();
        new Line(bottomLeft, topLeft).draw();
    }
}
