package nation;

import house.IHouse;
import river.IWaterSource;
import terrain.ITerrain;
import tree.ITree;

public interface INation {
    ITerrain getTerrain();
    IHouse getHouse();
    ITree getTree();
    IWaterSource getWaterSource();
}
