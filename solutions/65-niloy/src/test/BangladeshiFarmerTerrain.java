package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BangladeshiFarmerTerrain {
    @Test
    public void terrainColorTest(){
        terrain.BangladeshiFarmerTerrain terrain = new terrain.BangladeshiFarmerTerrain();
        String expectedColorCode = "#d9f5a6";
        assertEquals(expectedColorCode, terrain.draw());
    }
}
