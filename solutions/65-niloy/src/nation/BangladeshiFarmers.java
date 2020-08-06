package nation;

import house.BangladeshiFarmersHouse;
import house.IHouse;
import terrain.BangladeshiFarmerTerrain;
import terrain.ITerrain;

public class BangladeshiFarmers implements INation{
    @Override
    public void drawTerrain() {

    }

    @Override
    public IHouse getHouse() {
        return new BangladeshiFarmersHouse();
    }

    @Override
    public void drawTree() {

    }

    @Override
    public void drawRiver() {

    }
}
