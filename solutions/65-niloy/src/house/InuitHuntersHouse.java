package house;

import canvas.CanvasSingleton;
import house.IHouse;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.ArcType;
import shape.Point;

public class InuitHuntersHouse implements IHouse {
    private Canvas canvas;
    private boolean shouldBeDrawn = true;

    private Point one;
    private Point two;
    private Point center;


    public InuitHuntersHouse() {
        CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
        this.canvas = canvasSingleton.getCanvas();
    }

    private void calculateCornerPoints(Point selectedPoint) {
        one = new Point(selectedPoint.x - 4, selectedPoint.y - 8);
        two = new Point(selectedPoint.x - 12, selectedPoint.y + 8);
        center = new Point(selectedPoint.x , selectedPoint.y + 8);
    }

    @Override
    public void draw() {
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        if (shouldBeDrawn) {
                            calculateCornerPoints(new Point((int) event.getX(), (int) event.getY()));

                            graphicsContext.strokeLine(one.x, one.y, two.x, two.y);
                            graphicsContext.strokeArc(center.x, center.y, 12, 12, 0, 180, ArcType.OPEN);
                            graphicsContext.strokeArc(center.x, center.y, 24, 24, 0, 180, ArcType.OPEN);

                        }
                    }
                });
    }

    @Override
    public void releaseCanvas() {
        shouldBeDrawn = false;
    }

    @Override
    public void getCanvas() {
        shouldBeDrawn = true;
    }
}
