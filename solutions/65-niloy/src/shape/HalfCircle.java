package shape;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

public class HalfCircle implements IShape{
    private Point center;
    private int diameter;
    private GraphicsContext graphicsContext;

    public HalfCircle(Point center, int diameter, GraphicsContext graphicsContext) {
        this.center = center;
        this.diameter = diameter;
        this.graphicsContext = graphicsContext;
    }

    @Override
    public void draw() {
        graphicsContext.strokeArc(center.x, center.y, diameter, diameter, 0, 180, ArcType.ROUND);
    }
}
