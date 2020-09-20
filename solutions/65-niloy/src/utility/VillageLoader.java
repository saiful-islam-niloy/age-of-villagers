package utility;

import canvas.CanvasSingleton;
import com.google.gson.JsonArray;
import nation.NationManager;
import shape.Point;

public class VillageLoader {
    private CanvasSingleton canvasSingleton;
    private NationManager nationManager;

    public VillageLoader(NationManager nationManager) {
        canvasSingleton = CanvasSingleton.getInstance();
        this.nationManager = nationManager;
    }

    public void loadTerrain(){
        nationManager.getTerrain().draw();
    }

    public void loadTree(JsonArray treeX, JsonArray treeY){
        for (int i = 0; i< treeX.size(); i++)
            nationManager.getTree().draw(new Point(treeX.get(i).getAsInt(), treeY.get(i).getAsInt()));
    }

    public void loadHouse(JsonArray houseX, JsonArray houseY){
        for (int i = 0; i< houseX.size(); i++)
            nationManager.getHouse().draw(new Point(houseX.get(i).getAsInt(), houseY.get(i).getAsInt()));
    }

    public void loadWaterResource(JsonArray waterResourceX, JsonArray waterResourceY){
        for (int i = 0; i< waterResourceX.size(); i++)
            nationManager.getWaterSource().draw(new Point(waterResourceX.get(i).getAsInt(), waterResourceY.get(i).getAsInt()));
    }
}
