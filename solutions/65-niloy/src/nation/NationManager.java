package nation;

public class NationManager {
    private String nationType;

    public NationManager(String nationType) {
        this.nationType = nationType;
    }

    public void draw(){
        NationFactory nationFactory = new NationFactory();
        INation nation = nationFactory.getNation(nationType);
        nation.drawTerrain();
        nation.drawHouse();
        nation.drawTree();
        nation.drawRiver();
    }
}
