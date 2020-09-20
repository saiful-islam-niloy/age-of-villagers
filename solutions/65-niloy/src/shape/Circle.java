package shape;

import canvas.CanvasSingleton;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

public class Circle implements IShape{
    private Point center;
    private int diameter;
    private GraphicsContext graphicsContext;
    private CanvasSingleton canvasSingleton;
    private Canvas canvas;

    public Circle(Point center, int diameter, GraphicsContext graphicsContext) {
        this.center = center;
        this.diameter = diameter;
        this.graphicsContext = graphicsContext;
        this.graphicsContext = graphicsContext;
        canvasSingleton = CanvasSingleton.getInstance();
    }

    @Override
    public void draw() {
        canvas = canvasSingleton.getCanvas();
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.strokeArc(center.x, center.y, diameter, diameter, 0, 360, ArcType.OPEN);
    }
}
