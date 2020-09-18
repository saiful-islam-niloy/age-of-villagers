package river;

import canvas.CanvasSingleton;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import shape.Line;
import shape.Point;
import state.CurrentState;

public class BangladeshiFarmersWaterSource implements IWaterSource{
    private Canvas canvas;
    private boolean shouldBeDrawn;
    private CanvasSingleton canvasSingleton;
    private CurrentState currentState;

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
        currentState = CurrentState.getInstance();
    }

    private void calculateCornerPoints(Point selectedPoint) {
        currentState.addWaterResource(selectedPoint);
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

                            new Line(one, two, graphicsContext).draw();
                            new Line(two, three, graphicsContext).draw();
                            new Line(three, four, graphicsContext).draw();
                            new Line(four, five, graphicsContext).draw();
                            new Line(five, six, graphicsContext).draw();
                            new Line(six, seven, graphicsContext).draw();
                            new Line(seven, eight, graphicsContext).draw();
                            new Line(eight, nine, graphicsContext).draw();
                            new Line(nine, one, graphicsContext).draw();
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
