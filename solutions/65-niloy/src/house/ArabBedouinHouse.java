package house;

import canvas.CanvasSingleton;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import shape.Line;
import shape.Point;

public class ArabBedouinHouse implements IHouse{
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private boolean shouldBeDrawn = true;

    private Point one;
    private Point two;
    private Point three;
    private Point four;
    private Point five;


    public ArabBedouinHouse() {
        CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
        this.canvas = canvasSingleton.getCanvas();
    }

    private void calculateCornerPoints(Point selectedPoint) {
        one = new Point(selectedPoint.x-12, selectedPoint.y + 8);
        two = new Point(selectedPoint.x , selectedPoint.y +8);
        three = new Point(selectedPoint.x + 12, selectedPoint.y + 8);
        four = new Point(selectedPoint.x + 6, selectedPoint.y - 8);
        five = new Point(selectedPoint.x - 6, selectedPoint.y - 8);
    }

    @Override
    public void draw(Point point) {
        calculateCornerPoints(point);
        new Line(one, two).draw();
        new Line(two, three).draw();
        new Line(three, four).draw();
        new Line(four, five).draw();
        new Line(five, one).draw();
        new Line(five, two).draw();
    }

    @Override
    public void canvasController() {
        graphicsContext = canvas.getGraphicsContext2D();

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        if (shouldBeDrawn) {
                            draw(new Point((int) event.getX(), (int) event.getY()));
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
