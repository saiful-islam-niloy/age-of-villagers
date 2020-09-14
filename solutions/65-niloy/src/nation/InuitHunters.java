package nation;

import house.IHouse;
import house.InuitHuntersHouse;
import river.IWaterSource;
import river.NullRiver;
import terrain.ITerrain;
import terrain.InuitHuntersTerrain;
import tree.ITree;
import tree.NullTree;

public class InuitHunters implements INation{
    @Override
    public ITerrain getTerrain() {
        return new InuitHuntersTerrain();
    }

    @Override
    public IHouse getHouse() {
        return new InuitHuntersHouse();
    }

    @Override
    public ITree getTree() {
        return new NullTree();
    }

    @Override
    public IWaterSource getWaterSource() {
        return new NullRiver();
    }
}
