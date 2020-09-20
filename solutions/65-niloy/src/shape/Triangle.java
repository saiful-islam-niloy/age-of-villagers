package shape;

public class Triangle implements  IShape{
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    @Override
    public void draw() {
        new Line(point1, point2).draw();
        new Line(point2, point3).draw();
        new Line(point1, point3).draw();
    }
}
