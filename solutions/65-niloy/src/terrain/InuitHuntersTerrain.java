package terrain;

import canvas.CanvasSingleton;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class InuitHuntersTerrain implements ITerrain {
    private String colorCode;
    @Override
    public String draw() {
        CanvasSingleton canvasSingleton = CanvasSingleton.getInstance();
        GraphicsContext graphicsContext = canvasSingleton.getCanvas().getGraphicsContext2D();
        colorCode = "#ffffff";
        graphicsContext.setFill(Color.web(colorCode));
        graphicsContext.fillRect(0,0,600,400);
        return colorCode;
    }
}
