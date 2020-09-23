package terrain;

import canvas.CanvasSingleton;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BangladeshiFarmerTerrain implements ITerrain{
    private String colorCode;
    @Override
    public void draw() {
        CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
        GraphicsContext graphicsContext = canvasSingleton.getCanvas().getGraphicsContext2D();
        colorCode = "#d9f5a6";
        graphicsContext.setFill(Color.web(colorCode));
        graphicsContext.fillRect(0,0,600,400);
    }
}
