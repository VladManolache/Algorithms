/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.graph.search;
 
import algorithms.utils.PathUtils;
import org.junit.Assert;
import org.junit.Test; 

/**
 *
 * @author vmanolache
 */
public class ConnectedComponetsTest {
     
    @Test
    public void mainTest() {
        ConnectedComponents connectedComponents = new ConnectedComponents(PathUtils.getPath() + "graph/connectedComponents.txt", false);
        int count = connectedComponents.connectedComponents();
        
        Assert.assertEquals(count, 3);
    }
}
