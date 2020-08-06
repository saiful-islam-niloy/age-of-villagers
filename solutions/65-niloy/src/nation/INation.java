package nation;

import house.IHouse;
import river.IWaterSource;
import tree.ITree;

public interface INation {
    void drawTerrain();
    IHouse getHouse();
    ITree getTree();
    IWaterSource getWaterSource();
}
