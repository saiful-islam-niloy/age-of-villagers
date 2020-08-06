package nation;

import house.IHouse;
import river.IWaterSource;
import tree.ITree;

public class NationManager {
    private String nationType;
    private INation nation;
    private NationFactory nationFactory;

    public NationManager(String nationType) {
        this.nationType = nationType;
        nationFactory = new NationFactory();
        nation = nationFactory.getNation(nationType);
    }

    public void draw(){
//        nation.drawTerrain();
        nation.getHouse().draw();
//        nation.drawTree();
//        nation.drawRiver();
    }

    public IHouse getHouse(){
        return (IHouse)nation.getHouse();
    }


    public ITree getTree(){
        return (ITree) nation.getTree();
    }

    public IWaterSource getWaterSource(){
        return (IWaterSource) nation.getWaterSource();
    }
}
