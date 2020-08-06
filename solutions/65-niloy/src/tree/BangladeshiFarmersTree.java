package tree;

import canvas.CanvasSingleton;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.ArcType;
import shape.Point;

public class BangladeshiFarmersTree implements ITree {
    private Canvas canvas;

    private Point one;
    private Point two;
    private Point three;
    private Point four;
    private Point center;

    private GraphicsContext graphicsContext;
    private CanvasSingleton canvasSingleton;

    private boolean shouldBeDrawn = true;

    public BangladeshiFarmersTree() {
        canvasSingleton = CanvasSingleton.getInstance();
        this.canvas = canvasSingleton.getCanvas();
    }

    private void calculateCornerPoints(Point selectedPoint) {
        one = new Point(selectedPoint.x + 2, selectedPoint.y - 4);
        two = new Point(selectedPoint.x + 2, selectedPoint.y + 12);
        three = new Point(selectedPoint.x - 2, selectedPoint.y + 12);
        four = new Point(selectedPoint.x - 2, selectedPoint.y - 4);
        center = new Point(selectedPoint.x - 8, selectedPoint.y - 12);
    }

    @Override
    public void draw() {
        graphicsContext = canvas.getGraphicsContext2D();

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
                            graphicsContext.strokeArc(center.x, center.y, 16, 16, 0, 360, ArcType.OPEN);
                            System.out.println("inside draw 2");
                        }
                    }
                });
        System.out.println("inside draw");
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
