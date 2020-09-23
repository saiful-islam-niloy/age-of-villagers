package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InuitHuntersTerrain {
    @Test
    public void terrainColorTest(){
        terrain.InuitHuntersTerrain terrain = new terrain.InuitHuntersTerrain();
        String expectedColorCode = "#ffffff";
        assertEquals(expectedColorCode, terrain.draw());
    }
}
