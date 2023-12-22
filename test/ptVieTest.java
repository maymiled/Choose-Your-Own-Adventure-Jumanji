package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

//import static org.junit.api.Assertions.assertNotEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;


import representation.DecisionNode;
import representation.Node;
import representation.TerminalNode;
import univers.BanqueEnigme;
import univers.ChoixSimple;
import univers.CourseMontre;
import univers.Enigme;
import vue.FabriqueUI;
import representation.Graph;

/**
 *
 */
public class ptVieTest {
	
	public ptVieTest()
	{
	}

	@Test
	public void testEnigmeReussi() {
		BanqueEnigme banqueEnigme = new BanqueEnigme();
		Enigme enigme = banqueEnigme.getRandomEnigme();		
		enigme.reponseUtilisateur=enigme.indiceRepCorr;		
		assertTrue(enigme.aGagner(FabriqueUI.getUI()));
	}
		
}
