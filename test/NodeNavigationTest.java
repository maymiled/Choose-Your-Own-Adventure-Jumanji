package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

//import static org.junit.api.Assertions.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;


import representation.DecisionNode;
import representation.Node;
import representation.TerminalNode;
import univers.ChoixSimple;
import univers.CourseMontre;
import representation.Graph;

/**
 *
 */
public class NodeNavigationTest {
	
	public NodeNavigationTest()
	{
		
	}

	@Test
	public void testNodeNavigation() {
		DecisionNode decisionNode = new DecisionNode("decision",new ChoixSimple());
		TerminalNode terminalNode = new TerminalNode("terminal");
		decisionNode.addNextNodes(terminalNode);
		
		Node node = decisionNode.chooseNext();
		
		assertTrue(node instanceof TerminalNode);
	}
	
	

}
