package river;

import canvas.CanvasSingleton;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import shape.Circle;
import shape.Point;

public class EgyptianKingsWaterSource implements IWaterSource {
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private boolean shouldBeDrawn;
    private CanvasSingleton canvasSingleton;

    private Point center;

    public EgyptianKingsWaterSource() {
        canvasSingleton = CanvasSingleton.getInstance();
        this.canvas = canvasSingleton.getCanvas();
    }

    private void calculateCornerPoints(Point selectedPoint) {
        center = new Point(selectedPoint.x, selectedPoint.y);
    }

    @Override
    public void draw(Point point) {
        calculateCornerPoints(point);
        new Circle(center, 12).draw();
    }

    @Override
    public void canvasController() {
        graphicsContext = canvas.getGraphicsContext2D();

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        if (shouldBeDrawn) {
                            draw(new Point((int) event.getX(), (int) event.getY()));
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
