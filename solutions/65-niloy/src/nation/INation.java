package nation;

import house.IHouse;
import tree.ITree;

public interface INation {
    void drawTerrain();
    IHouse getHouse();
    ITree getTree();
    void drawRiver();
}
