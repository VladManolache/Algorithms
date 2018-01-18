/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graph.search;
 
import algorithms.utils.PathUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 *
 * @author vmanolache
 */
public class ConnectedComponetsTest {
     
    @Test
    public void mainTest() {
        ConnectedComponents connectedComponents = new ConnectedComponents(PathUtils.getPath() + "graph/connectedComponents.txt", false);
        int count = connectedComponents.connectedComponents();
        
        assertEquals(count, 3);
    }
}
