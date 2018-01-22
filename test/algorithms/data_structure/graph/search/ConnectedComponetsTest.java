/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.data_structure.graph.search;
 
import algorithms.common.PathUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author vmanolache
 */
public class ConnectedComponetsTest {
     
    @Test
    void mainTest() {
        ConnectedComponents connectedComponents = new ConnectedComponents(PathUtils.getPath() + "data_structure/graph/search/connectedComponents.txt", false);
        int count = connectedComponents.connectedComponents();
        
        assertEquals(count, 3);
    }
}
