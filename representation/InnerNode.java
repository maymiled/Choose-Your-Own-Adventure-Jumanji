package representation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe qui d�finit un noeud non terminal
 *
 */
public abstract class InnerNode extends Node {

	/**
	 * La liste des noeud fils que le joueur peut choisir � partir de ce noeud
	 */
	protected List<Node> nextNodes = new ArrayList<>();


	public InnerNode(String description) {
		super(description);
	}

	/**
	 * 
	 * @return
	 */


	/**
	 * 
	 * @param nextNodes
	 */
	public void addNextNodes(Node nextNode) {
		this.nextNodes.add(nextNode);
	}

}
