package tree;

import canvas.CanvasSingleton;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import shape.Point;

public class EgyptianKingsTree implements ITree{
    private Canvas canvas;
    private boolean shouldBeDrawn;

    private Point one;
    private Point two;
    private Point three;
    private Point four;
    private Point five;
    private Point six;
    private Point seven;
    private Point eight;
    private Point nine;


    public EgyptianKingsTree() {
        CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
        this.canvas = canvasSingleton.getCanvas();
    }

    private void calculateCornerPoints(Point selectedPoint) {
        one = new Point(selectedPoint.x , selectedPoint.y + 8);
        two = new Point(selectedPoint.x - 6, selectedPoint.y );
        three = new Point(selectedPoint.x + 6, selectedPoint.y );

        four = new Point(selectedPoint.x - 12, selectedPoint.y );
        five = new Point(selectedPoint.x - 7, selectedPoint.y -4);
        six = new Point(selectedPoint.x - 2, selectedPoint.y - 4);

        seven = new Point(selectedPoint.x + 2, selectedPoint.y - 4);
        eight = new Point(selectedPoint.x + 7, selectedPoint.y - 4);
        nine = new Point(selectedPoint.x + 12, selectedPoint.y );
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
                            graphicsContext.strokeLine(one.x, one.y, three.x, three.y);

                            graphicsContext.strokeLine(two.x, two.y, four.x, four.y);
                            graphicsContext.strokeLine(two.x, two.y, five.x, five.y);
                            graphicsContext.strokeLine(two.x, two.y, six.x, six.y);

                            graphicsContext.strokeLine(three.x, three.y, seven.x, seven.y);
                            graphicsContext.strokeLine(three.x, three.y, eight.x, eight.y);
                            graphicsContext.strokeLine(three.x, three.y, nine.x, nine.y);

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
