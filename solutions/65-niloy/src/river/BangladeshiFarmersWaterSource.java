package river;

import canvas.CanvasSingleton;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import shape.Point;

public class BangladeshiFarmersWaterSource implements IWaterSource{
    private Canvas canvas;
    private boolean shouldBeDrawn;
    private CanvasSingleton canvasSingleton;

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
    public void draw() {
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent event) {
                        if(shouldBeDrawn){
                            calculateCornerPoints(new Point((int)event.getX(), (int)event.getY()));

                            graphicsContext.strokeLine(one.x, one.y, two.x, two.y);
                            graphicsContext.strokeLine(two.x, two.y, three.x, three.y);
                            graphicsContext.strokeLine(three.x, three.y, four.x, four.y);
                            graphicsContext.strokeLine(four.x, four.y, five.x, five.y);
                            graphicsContext.strokeLine(five.x, five.y, six.x, six.y);
                            graphicsContext.strokeLine(six.x, six.y, seven.x, seven.y);
                            graphicsContext.strokeLine(seven.x, seven.y, eight.x, eight.y);
                            graphicsContext.strokeLine(eight.x, eight.y, nine.x, nine.y);
                            graphicsContext.strokeLine(nine.x, nine.y, one.x, one.y);
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
