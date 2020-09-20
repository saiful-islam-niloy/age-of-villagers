package shape;

import canvas.CanvasSingleton;
import javafx.scene.canvas.GraphicsContext;

public class Line implements IShape {
    private Point point1;
    private Point point2;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    @Override
    public void draw() {
        CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
        GraphicsContext graphicsContext = canvasSingleton.getCanvas().getGraphicsContext2D();
        graphicsContext.strokeLine(point1.x, point1.y, point2.x, point2.y);
    }
}
