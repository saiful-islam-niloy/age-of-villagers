package house;

import canvas.CanvasSingleton;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import shape.Line;
import shape.Point;
import state.CurrentState;

public class EgyptianKingsHouse implements IHouse {
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private CurrentState currentState;
    private boolean shouldBeDrawn = true;

    private Point one;
    private Point two;
    private Point three;
    private Point four;


    public EgyptianKingsHouse() {
        CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
        this.canvas = canvasSingleton.getCanvas();
        currentState = CurrentState.getInstance();
    }

    private void calculateCornerPoints(Point selectedPoint) {
        one = new Point(selectedPoint.x - 4, selectedPoint.y - 8);
        two = new Point(selectedPoint.x - 12, selectedPoint.y + 8);
        three = new Point(selectedPoint.x + 4, selectedPoint.y + 8);
        four = new Point(selectedPoint.x + 12, selectedPoint.y);
    }

    @Override
    public void draw(Point point) {
        calculateCornerPoints(point);
        new Line(one, two).draw();
        new Line(one, three).draw();
        new Line(one, four).draw();
        new Line(two, three).draw();
        new Line(three, four).draw();
    }

    @Override
    public void canvasController() {
        graphicsContext = canvas.getGraphicsContext2D();

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        if (shouldBeDrawn) {
                            Point selectedPoint = new Point((int) event.getX(), (int) event.getY());
                            draw(selectedPoint);
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
