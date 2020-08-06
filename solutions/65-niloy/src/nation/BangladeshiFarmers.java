package nation;

import house.BangladeshiFarmersHouse;
import house.IHouse;
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
    public void drawRiver() {

    }
}
