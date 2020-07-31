package canvas;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.ArcType;

public class CanvasHelper {
    private javafx.scene.canvas.Canvas canvas;
    private int i = 1;

    public CanvasHelper(javafx.scene.canvas.Canvas canvas) {
        this.canvas = canvas;
    }
    public void execute(){
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>(){

                    @Override
                    public void handle(MouseEvent event) {
                        graphicsContext.fillArc(10*i,20*i,30*i,40*i,50*i,60*i, ArcType.ROUND);
                        i ++;
                        graphicsContext.setLineWidth(1);
                        String x = String.valueOf(event.getX());
                        String y = String.valueOf(event.getY());
                        System.out.println(x+", "+y);
                    }
                });

    }
}
