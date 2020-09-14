package tree;

import canvas.CanvasSingleton;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import shape.Line;
import shape.Point;
import shape.Rectangle;

public class ArabBedouinTree implements ITree{
    private Canvas canvas;
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
    public void draw() {
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        if (shouldBeDrawn) {
                            calculateCornerPoints(new Point((int) event.getX(), (int) event.getY()));

                            new Rectangle(topLeft, bottomRight, graphicsContext).draw();

                            new Line(topLeft, one, graphicsContext).draw();
                            new Line(topLeft, two, graphicsContext).draw();
                            new Line(topLeft, three, graphicsContext).draw();
                            new Line(topLeft, four, graphicsContext).draw();
                            new Line(topLeft, five, graphicsContext).draw();

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
