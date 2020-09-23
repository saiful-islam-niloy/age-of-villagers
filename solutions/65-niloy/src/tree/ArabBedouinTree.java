package tree;

import canvas.CanvasSingleton;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import shape.Line;
import shape.Point;
import shape.Rectangle;
import state.CurrentState;

public class ArabBedouinTree implements ITree{
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private CurrentState currentState;
    private boolean shouldBeDrawn;

    private Point topLeft;
    private Point bottomRight;
    private Point one;
    private Point two;
    private Point three;
    private Point four;
    private Point five;


    public ArabBedouinTree() {
        CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
        this.canvas = canvasSingleton.getCanvas();
        currentState = CurrentState.getInstance();
    }

    private void calculateCornerPoints(Point selectedPoint) {
        topLeft = new Point(selectedPoint.x + 2, selectedPoint.y - 4);
        bottomRight = new Point(selectedPoint.x - 2, selectedPoint.y + 12);

        one = new Point(selectedPoint.x, selectedPoint.y - 12);
        two = new Point(selectedPoint.x + 4, selectedPoint.y - 9);
        three = new Point(selectedPoint.x - 4, selectedPoint.y - 9);
        four = new Point(selectedPoint.x + 8, selectedPoint.y - 6);
        five = new Point(selectedPoint.x - 8, selectedPoint.y - 6);
    }

    @Override
    public boolean load(Point point) {
        calculateCornerPoints(point);
        new Rectangle(topLeft, bottomRight).draw();

        new Line(topLeft, one).draw();
        new Line(topLeft, two).draw();
        new Line(topLeft, three).draw();
        new Line(topLeft, four).draw();
        new Line(topLeft, five).draw();
        return true;
    }

    @Override
    public boolean draw() {
        graphicsContext = canvas.getGraphicsContext2D();

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        if(shouldBeDrawn){
                            Point selectedPoint = new Point((int) event.getX(), (int) event.getY()) ;
                            load(selectedPoint);
                            currentState.addTree(selectedPoint);
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
