package nation;

import house.BangladeshiFarmersHouse;
import house.IHouse;
import river.BangladeshiFarmersWaterSource;
import river.IWaterSource;
import tree.BangladeshiFarmersTree;
import tree.ITree;

public class BangladeshiFarmers implements INation {
    @Override
    public void drawTerrain() {

    }

    @Override
    public IHouse getHouse() {
        return new BangladeshiFarmersHouse();
    }

    @Override
    public ITree getTree() {
        return new BangladeshiFarmersTree();
    }

    @Override
    public IWaterSource getWaterSource() {
        return new BangladeshiFarmersWaterSource();
    }
}
