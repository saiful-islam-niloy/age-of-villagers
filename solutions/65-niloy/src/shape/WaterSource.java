package shape;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class WaterSource implements Shape {
    private Canvas canvas;

    private Point one;
    private Point two;
    private Point three;
    private Point four;
    private Point five;
    private Point six;

    public WaterSource(Canvas canvas) {
        this.canvas = canvas;
    }

    private void findNewPoints(Point selectedPoint){
        one = new Point(selectedPoint.x, selectedPoint.y-8);
        two = new Point(selectedPoint.x-8, selectedPoint.y-2);
        three = new Point(selectedPoint.x-8, selectedPoint.y+8);
        four = new Point(selectedPoint.x+8, selectedPoint.y+8);
        five = new Point(selectedPoint.x+8, selectedPoint.y-2);
        six = new Point(selectedPoint.x, selectedPoint.y+8);
    }

    @Override
    public void draw() {
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent event) {
                        findNewPoints(new Point((int)event.getX(), (int)event.getY()));

                        graphicsContext.strokeLine(one.x, one.y, two.x, two.y);
                        graphicsContext.strokeLine(two.x, two.y, three.x, three.y);
                        graphicsContext.strokeLine(three.x, three.y, four.x, four.y);
                        graphicsContext.strokeLine(four.x, four.y, five.x, five.y);
                        graphicsContext.strokeLine(five.x, five.y, six.x, six.y);
                        graphicsContext.strokeLine(one.x, one.y, six.x, six.y);
                    }
                });
    }
}
