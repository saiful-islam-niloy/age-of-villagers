package house;

import canvas.CanvasSingleton;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import shape.Point;
import shape.Rectangle;
import shape.Triangle;
import state.CurrentState;

public class BangladeshiFarmersHouse implements IHouse {
    private Canvas canvas;
    private GraphicsContext graphicsContext;

    private Point topLeft;
    private Point bottomRight;
    private Point one;
    private Point two;

    private boolean shouldBeDrawn = true;
    private CurrentState currentState;

    public BangladeshiFarmersHouse() {
        CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
        this.canvas = canvasSingleton.getCanvas();
        currentState = CurrentState.getInstance();
    }

    private void calculateCornerPoints(Point selectedPoint) {
        topLeft = new Point(selectedPoint.x - 8, selectedPoint.y - 2);
        bottomRight = new Point(selectedPoint.x + 8, selectedPoint.y + 8);

        one = new Point(selectedPoint.x, selectedPoint.y - 8);
        two = new Point(selectedPoint.x + 8, selectedPoint.y - 2);
    }

    @Override
    public void load(Point point) {
        calculateCornerPoints(point);
        new Triangle(one, topLeft, two).draw();
        new Rectangle(topLeft, bottomRight).draw();
    }

    @Override
    public void draw() {
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
