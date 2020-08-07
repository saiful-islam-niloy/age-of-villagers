package nation;

import house.IHouse;
import river.EgyptianKingsWaterSource;
import river.IWaterSource;
import terrain.EgyptianKingsTerrain;
import terrain.ITerrain;
import tree.EgyptianKingsTree;
import tree.ITree;

public class EgyptianKings implements INation{
    @Override
    public ITerrain getTerrain() {
        return new EgyptianKingsTerrain();
    }

    @Override
    public IHouse getHouse() {
        return null;
    }

    @Override
    public ITree getTree() {
        return new EgyptianKingsTree();
    }

    @Override
    public IWaterSource getWaterSource() {
        return new EgyptianKingsWaterSource();
    }
}
