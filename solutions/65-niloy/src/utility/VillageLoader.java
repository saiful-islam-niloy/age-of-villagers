package utility;

import canvas.CanvasSingleton;
import com.google.gson.JsonArray;
import nation.NationManager;
import shape.Point;

public class VillageLoader {
    private CanvasSingleton canvasSingleton;
    private String villageType;
    private NationManager nationManager;

    public VillageLoader(String villageType) {
        this.villageType = villageType;
        canvasSingleton = CanvasSingleton.getInstance();
        nationManager = new NationManager(villageType);
    }

    public void loadTree(JsonArray treeX, JsonArray treeY){
        for (int i = 0; i< treeX.size(); i++)
            nationManager.getTree().draw(new Point(treeX.get(i).getAsInt(), treeY.get(i).getAsInt()));
    }

    public void loadTerrain(){
        nationManager.getTerrain().draw();
    }
}