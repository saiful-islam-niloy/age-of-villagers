package house;

import canvas.CanvasSingleton;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import shape.HalfCircle;
import shape.Point;

public class InuitHuntersHouse implements IHouse {
    private Canvas canvas;
    private boolean shouldBeDrawn = true;

    private Point center;
    private Point center2;


    public InuitHuntersHouse() {
        CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
        this.canvas = canvasSingleton.getCanvas();
    }

    private void calculateCornerPoints(Point selectedPoint) {
        center = new Point(selectedPoint.x -12, selectedPoint.y );
        center2 = new Point(selectedPoint.x -4, selectedPoint.y +8);
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

                            new HalfCircle(center2, 8, graphicsContext).draw();
                            new HalfCircle(center, 24, graphicsContext).draw();
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
