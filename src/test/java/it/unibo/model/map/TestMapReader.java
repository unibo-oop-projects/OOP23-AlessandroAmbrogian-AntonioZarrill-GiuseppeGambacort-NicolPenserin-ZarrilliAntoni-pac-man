package it.unibo.model.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.model.map.impl.MapReaderImpl;

public class TestMapReader {
    private MapReaderImpl mapReader;

    @BeforeEach
    void setUp() {
        String filePath = "src/main/resources/map1.txt";
        this.mapReader = new MapReaderImpl(filePath);
    }

    @Test
    void testGetMap() {
        int [][] expectedMap = {
            {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},
            {5,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,0,5},
            {5,0,5,5,5,5,0,5,5,5,5,0,5,0,5,5,5,5,0,5,5,5,5,0,5},
            {5,0,5,5,5,5,0,5,5,5,5,0,5,0,5,5,5,5,0,5,5,5,5,0,5},
            {5,0,5,5,5,5,0,5,5,5,5,0,5,0,5,5,5,5,0,5,5,5,5,0,5},
            {5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5},
            {5,0,5,5,5,5,0,5,0,5,5,5,5,5,5,5,0,5,0,5,5,5,5,0,5},
            {5,0,5,5,5,5,0,5,0,5,5,5,5,5,5,5,0,5,0,5,5,5,5,0,5},
            {5,0,0,0,0,0,0,5,0,0,0,0,5,0,0,0,0,5,0,0,0,0,0,0,5},
            {5,5,5,5,5,5,0,5,5,5,5,1,5,1,5,5,5,5,0,5,5,5,5,5,5},
            {5,5,5,5,5,5,0,5,1,1,1,1,1,1,1,1,1,5,0,5,5,5,5,5,5},
            {5,5,5,5,5,5,0,5,1,5,5,5,4,5,5,5,1,5,0,5,5,5,5,5,5},
            {0,0,0,0,0,0,0,1,1,5,5,3,3,3,5,5,1,1,0,0,0,0,0,0,0},
            {5,5,5,5,5,5,0,5,1,5,5,5,5,5,5,5,1,5,0,5,5,5,5,5,5},
            {5,5,5,5,5,5,0,5,1,1,1,1,1,1,1,1,1,5,0,5,5,5,5,5,5},
            {5,5,5,5,5,5,0,5,1,5,5,5,5,5,5,5,1,5,0,5,5,5,5,5,5},
            {5,0,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,0,5},
            {5,0,5,5,5,5,0,5,5,5,5,0,5,0,5,5,5,5,0,5,5,5,5,0,5},
            {5,0,5,5,5,5,0,5,5,5,5,0,5,0,5,5,5,5,0,5,5,5,5,0,5},
            {5,0,0,0,5,5,0,0,0,0,0,0,2,0,0,0,0,0,0,5,5,0,0,0,5},
            {5,5,5,0,5,5,0,5,5,0,5,5,5,5,5,0,5,5,0,5,5,0,5,5,5},
            {5,5,5,0,5,5,0,5,5,0,5,5,5,5,5,0,5,5,0,5,5,0,5,5,5},
            {5,0,0,0,0,0,0,5,5,0,0,0,5,0,0,0,5,5,0,0,0,0,0,0,5},
            {5,0,5,5,5,5,5,5,5,5,5,0,5,0,5,5,5,5,5,5,5,5,5,0,5},
            {5,0,5,5,5,5,5,5,5,5,5,0,5,0,5,5,5,5,5,5,5,5,5,0,5},
            {5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5},
            {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5}
        };
        int[][] actualMap = this.mapReader.getMap();
        assertEquals(expectedMap.length, actualMap.length);
        for(int i = 0; i < expectedMap.length; i++) {
            assertEquals(expectedMap[i].length, actualMap[i].length);
            for(int j = 0; j < expectedMap[i].length; j++) {
                assertEquals(expectedMap[i][j], actualMap[i][j]);
            }
        }

    }
}
