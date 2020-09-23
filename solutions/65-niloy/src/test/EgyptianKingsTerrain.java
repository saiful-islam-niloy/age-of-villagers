package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EgyptianKingsTerrain {
    @Test
    public void terrainColorTest(){
        terrain.EgyptianKingsTerrain terrain = new terrain.EgyptianKingsTerrain();
        String expectedColorCode = "#ffc80d";
        assertEquals(expectedColorCode, terrain.draw());
    }
}
