package representation;

import java.io.Serializable;
import java.util.List;
/**
 * Classe qui permet de construire l'univers du jeu
 *
 *     0  1  2  3  4 
 *   0 0  1  1  0 
 *   1
 *   2
 *   3
 *   4
 *
 *
 *
 *
 */
public class Graph implements Serializable{

	private List<Node> nodes;
	private int connexion[][];
	
	public Graph(List<Node> nodes, int connexion[][]) {
		this.nodes=nodes;
		this.connexion = connexion;
		etablirConnexion();		
	}
	
	
	private void etablirConnexion() {
		if (connexion.length!=nodes.size())
			throw new RuntimeException(" ");
		
		for(int i=0;i<connexion.length;i++)
		{
			
			Node node = nodes.get(i);
			if (!(node instanceof InnerNode))
				continue;
			InnerNode node_i = (InnerNode) node;
			for(int j=0;j<connexion[i].length;j++)
				if (connexion[i][j]==1)
				{
					node_i.addNextNodes(nodes.get(j));
				}			
		}
	}
	
	public Node getStartNode() {
		return nodes.get(0);
	}
	
}
