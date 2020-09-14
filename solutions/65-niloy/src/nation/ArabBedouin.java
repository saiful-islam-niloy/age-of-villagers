package nation;

import house.ArabBedouinHouse;
import house.IHouse;
import river.IWaterSource;
import river.NullRiver;
import terrain.ArabBedouinTerrain;
import terrain.ITerrain;
import tree.ArabBedouinTree;
import tree.ITree;

public class ArabBedouin implements INation{
    @Override
    public ITerrain getTerrain() {
        System.out.println("Arab terrain");
        return new ArabBedouinTerrain();
    }

    @Override
    public IHouse getHouse() {
        System.out.println("Arab House Object Returned");
        return new ArabBedouinHouse();
    }

    @Override
    public ITree getTree() {
        return new ArabBedouinTree();
    }

    @Override
    public IWaterSource getWaterSource() {
        return new NullRiver();
    }
}
