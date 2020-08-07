package nation;

import house.ArabBedouinHouse;
import house.IHouse;
import river.IWaterSource;
import terrain.ITerrain;
import tree.ITree;

public class ArabBedouin implements INation{
    @Override
    public ITerrain getTerrain() {
        return null;
    }

    @Override
    public IHouse getHouse() {
        return new ArabBedouinHouse();
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
