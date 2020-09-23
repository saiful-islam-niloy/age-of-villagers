package house;

import canvas.CanvasSingleton;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import shape.HalfCircle;
import shape.Point;
import state.CurrentState;

public class InuitHuntersHouse implements IHouse {
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private CurrentState currentState;
    private boolean shouldBeDrawn = true;

    private Point center;
    private Point center2;


    public InuitHuntersHouse() {
        CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
        this.canvas = canvasSingleton.getCanvas();
        currentState = CurrentState.getInstance();
    }

    private void calculateCornerPoints(Point selectedPoint) {
        center = new Point(selectedPoint.x -12, selectedPoint.y );
        center2 = new Point(selectedPoint.x -4, selectedPoint.y +8);
    }

    @Override
    public boolean load(Point point) {
        calculateCornerPoints(point);
        new HalfCircle(center2, 8).draw();
        new HalfCircle(center, 24).draw();
        return  true;
    }

    @Override
    public boolean draw() {
        graphicsContext = canvas.getGraphicsContext2D();

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        if (shouldBeDrawn) {
                            Point selectedPoint = new Point((int) event.getX(), (int) event.getY());
                            load(selectedPoint);
                            currentState.addHouse(selectedPoint);
                        }
                    }
                });
        return shouldBeDrawn;
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
