package test;

import org.junit.jupiter.api.Test;
import shape.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EgyptianKingsTree {
    @Test
    public void treeDraw(){
        tree.EgyptianKingsTree tree = new tree.EgyptianKingsTree();
        tree.getCanvas();
        assertEquals(true, tree.draw());
        tree.releaseCanvas();
    }

    @Test
    public void treeLoadOnCanvas(){
        tree.EgyptianKingsTree tree = new tree.EgyptianKingsTree();
        tree.getCanvas();
        assertEquals(true, tree.load(new Point(12,12)));
        tree.releaseCanvas();
    }
}
