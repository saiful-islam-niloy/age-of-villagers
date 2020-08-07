package nation;

import house.IHouse;
import river.IWaterSource;
import terrain.ITerrain;
import terrain.InuitHuntersTerrain;
import tree.ITree;

public class InuitHunters implements INation{
    @Override
    public ITerrain getTerrain() {
        return new InuitHuntersTerrain();
    }

    @Override
    public IHouse getHouse() {
        return null;
    }

    @Override
    public ITree getTree() {
        return null;
    }

    @Override
    public IWaterSource getWaterSource() {
        return null;
    }
}
