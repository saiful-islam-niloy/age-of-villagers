package house;

import canvas.CanvasSingleton;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import shape.Point;

public class BangladeshiFarmersHouse implements IHouse{
    private Canvas canvas;

    private Point one;
    private Point two;
    private Point three;
    private Point four;
    private Point five;

    public BangladeshiFarmersHouse() {
        CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
        this.canvas = canvasSingleton.getCanvas();
    }

    private void calculateCornerPoints(Point selectedPoint){
        one = new Point(selectedPoint.x, selectedPoint.y-8);
        two = new Point(selectedPoint.x-8, selectedPoint.y-2);
        three = new Point(selectedPoint.x-8, selectedPoint.y+8);
        four = new Point(selectedPoint.x+8, selectedPoint.y+8);
        five = new Point(selectedPoint.x+8, selectedPoint.y-2);
    }

    @Override
    public void draw() {
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent event) {
                        calculateCornerPoints(new Point((int)event.getX(), (int)event.getY()));

                        graphicsContext.strokeLine(one.x, one.y, two.x, two.y);
                        graphicsContext.strokeLine(two.x, two.y, three.x, three.y);
                        graphicsContext.strokeLine(three.x, three.y, four.x, four.y);
                        graphicsContext.strokeLine(four.x, four.y, five.x, five.y);
                        graphicsContext.strokeLine(five.x, five.y, one.x, one.y);
                        graphicsContext.strokeLine(two.x, two.y, five.x, five.y);
                    }
                });
    }
}
