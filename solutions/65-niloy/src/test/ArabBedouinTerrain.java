package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArabBedouinTerrain {
    @Test
    public void terrainColorTest(){
        terrain.ArabBedouinTerrain terrain = new terrain.ArabBedouinTerrain();
        String expectedColorCode = "#ffe796";
        assertEquals(expectedColorCode, terrain.draw());
    }
}
