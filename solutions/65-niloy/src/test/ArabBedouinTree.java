package test;

import org.junit.jupiter.api.Test;
import shape.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArabBedouinTree {
    @Test
    public void treeDraw(){
        tree.ArabBedouinTree tree = new tree.ArabBedouinTree();
        tree.getCanvas();
        assertEquals(true, tree.draw());
        tree.releaseCanvas();
    }

    @Test
    public void treeLoadOnCanvas(){
        tree.ArabBedouinTree tree = new tree.ArabBedouinTree();
        tree.getCanvas();
        assertEquals(true, tree.load(new Point(12,12)));
        tree.releaseCanvas();
    }
}
