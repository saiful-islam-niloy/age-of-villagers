package house;

import canvas.CanvasSingleton;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import shape.IShape;
import shape.Line;
import shape.Point;
import state.CurrentState;

import java.util.ArrayList;

public class ArabBedouinHouse implements IHouse{
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private CurrentState currentState;
    private boolean shouldBeDrawn = true;

    private Point one;
    private Point two;
    private Point three;
    private Point four;
    private Point five;

    private ArrayList<IShape> shapes;


    public ArabBedouinHouse() {
        CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
        this.canvas = canvasSingleton.getCanvas();
        currentState = CurrentState.getInstance();
        shapes = new ArrayList<>();
    }

    private void calculateCornerPoints(Point selectedPoint) {
        one = new Point(selectedPoint.x-12, selectedPoint.y + 8);
        two = new Point(selectedPoint.x , selectedPoint.y +8);
        three = new Point(selectedPoint.x + 12, selectedPoint.y + 8);
        four = new Point(selectedPoint.x + 6, selectedPoint.y - 8);
        five = new Point(selectedPoint.x - 6, selectedPoint.y - 8);
    }

    @Override
    public boolean load(Point point) {
        calculateCornerPoints(point);
        shapes.clear();
        shapes.add(new Line(one, two));
        shapes.add(new Line(two, three));
        shapes.add(new Line(three, four));
        shapes.add(new Line(four, five));
        shapes.add(new Line(five, one));
        shapes.add(new Line(five, two));

        for (int i = 0; i< shapes.size(); i++)
            shapes.get(i).draw();
        return true;
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
