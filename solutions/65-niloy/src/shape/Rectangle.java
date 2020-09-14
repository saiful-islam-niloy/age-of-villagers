package shape;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle implements IShape{
    private Point topLeft;
    private Point bottomRight;
    private Point topRight;
    private Point bottomLeft;
    private GraphicsContext graphicsContext;

    public Rectangle(Point topLeft, Point bottomRight, GraphicsContext graphicsContext) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.graphicsContext = graphicsContext;

        topRight = new Point(bottomRight.x, topLeft.y);
        bottomLeft = new Point(topLeft.x, bottomRight.y);
    }

    @Override
    public void draw() {
        new Line(topLeft, topRight, graphicsContext).draw();
        new Line(topRight, bottomRight, graphicsContext).draw();
        new Line(bottomRight, bottomLeft, graphicsContext).draw();
        new Line(bottomLeft, topLeft, graphicsContext).draw();
    }
}
