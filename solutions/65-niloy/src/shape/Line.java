package shape;

import javafx.scene.canvas.GraphicsContext;

public class Line implements IShape {
    private Point point1;
    private Point point2;
    private GraphicsContext graphicsContext;

    public Line(Point point1, Point point2, GraphicsContext graphicsContext) {
        this.point1 = point1;
        this.point2 = point2;
        this.graphicsContext = graphicsContext;
    }

    @Override
    public void draw() {
        graphicsContext.strokeLine(point1.x, point1.y, point2.x, point2.y);
    }
}
