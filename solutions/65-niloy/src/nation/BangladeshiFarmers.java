package nation;

import house.BangladeshiFarmersHouse;
import house.IHouse;
import river.BangladeshiFarmersWaterSource;
import river.IWaterSource;
import terrain.BangladeshiFarmerTerrain;
import terrain.ITerrain;
import tree.BangladeshiFarmersTree;
import tree.ITree;

public class BangladeshiFarmers implements INation {
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

    @Override
    public ITerrain getTerrain() {
        System.out.println("Bangladesh terrain Object Returned");
        return new BangladeshiFarmerTerrain();
    }
}
