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
            nationManager.getTree().load(new Point(treeX.get(i).getAsInt(), treeY.get(i).getAsInt()));
    }

    public void loadHouse(JsonArray houseX, JsonArray houseY){
        for (int i = 0; i< houseX.size(); i++)
            nationManager.getHouse().load(new Point(houseX.get(i).getAsInt(), houseY.get(i).getAsInt()));
    }

    public void loadWaterResource(JsonArray waterResourceX, JsonArray waterResourceY){
        for (int i = 0; i< waterResourceX.size(); i++)
            nationManager.getWaterSource().load(new Point(waterResourceX.get(i).getAsInt(), waterResourceY.get(i).getAsInt()));
    }
}
