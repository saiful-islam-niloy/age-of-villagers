package tree;

import canvas.CanvasSingleton;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.ArcType;
import shape.Point;

public class ArabBedouinTree implements ITree{
    private Canvas canvas;
    private boolean shouldBeDrawn = true;

    private Point one;
    private Point two;
    private Point three;
    private Point four;
    private Point five;
    private Point six;
    private Point seven;
    private Point eight;
    private Point nine;


    public ArabBedouinTree() {
        CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
        this.canvas = canvasSingleton.getCanvas();
    }

    private void calculateCornerPoints(Point selectedPoint) {
        one = new Point(selectedPoint.x + 2, selectedPoint.y - 4);
        two = new Point(selectedPoint.x + 2, selectedPoint.y + 12);
        three = new Point(selectedPoint.x - 2, selectedPoint.y + 12);
        four = new Point(selectedPoint.x - 2, selectedPoint.y - 4);

        five = new Point(selectedPoint.x, selectedPoint.y - 12);
        six = new Point(selectedPoint.x + 4, selectedPoint.y - 9);
        seven = new Point(selectedPoint.x - 4, selectedPoint.y - 9);
        eight = new Point(selectedPoint.x + 8, selectedPoint.y - 6);
        nine = new Point(selectedPoint.x - 8, selectedPoint.y - 6);
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
                            graphicsContext.strokeLine(two.x, two.y, three.x, three.y);
                            graphicsContext.strokeLine(three.x, three.y, four.x, four.y);
                            graphicsContext.strokeLine(four.x, four.y, one.x, one.y);

                            graphicsContext.strokeLine(one.x, one.y, five.x, five.y);
                            graphicsContext.strokeLine(one.x, one.y, six.x, six.y);
                            graphicsContext.strokeLine(one.x, one.y, seven.x, seven.y);
                            graphicsContext.strokeLine(one.x, one.y, eight.x, eight.y);
                            graphicsContext.strokeLine(one.x, one.y, nine.x, nine.y);

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
