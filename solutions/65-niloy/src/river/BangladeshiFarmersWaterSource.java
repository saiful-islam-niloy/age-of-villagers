package river;

import canvas.CanvasSingleton;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import shape.Line;
import shape.Point;
import state.CurrentState;

public class BangladeshiFarmersWaterSource implements IWaterSource{
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private boolean shouldBeDrawn;
    private CanvasSingleton canvasSingleton;
    private CurrentState currentState;

    private Point one;
    private Point two;
    private Point three;
    private Point four;
    private Point five;
    private Point six;
    private Point seven;
    private Point eight;
    private Point nine;

    public BangladeshiFarmersWaterSource() {
        canvasSingleton = CanvasSingleton.getInstance();
        this.canvas = canvasSingleton.getCanvas();
        currentState = CurrentState.getInstance();
    }

    private void calculateCornerPoints(Point selectedPoint) {
        one = new Point(selectedPoint.x - 12, selectedPoint.y);
        two = new Point(selectedPoint.x - 6, selectedPoint.y +4);
        three = new Point(selectedPoint.x - 3, selectedPoint.y + 8);
        four = new Point(selectedPoint.x - 2, selectedPoint.y + 1);
        five = new Point(selectedPoint.x + 4, selectedPoint.y + 8);
        six = new Point(selectedPoint.x + 12, selectedPoint.y + 4);
        seven = new Point(selectedPoint.x + 7, selectedPoint.y - 8);
        eight = new Point(selectedPoint.x + 2, selectedPoint.y - 2);
        nine = new Point(selectedPoint.x - 4, selectedPoint.y - 8);
    }


    @Override
    public void draw(Point point) {
        calculateCornerPoints(point);
        new Line(one, two).draw();
        new Line(two, three).draw();
        new Line(three, four).draw();
        new Line(four, five).draw();
        new Line(five, six).draw();
        new Line(six, seven).draw();
        new Line(seven, eight).draw();
        new Line(eight, nine).draw();
        new Line(nine, one).draw();
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
                            currentState.addWaterResource(selectedPoint);
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
