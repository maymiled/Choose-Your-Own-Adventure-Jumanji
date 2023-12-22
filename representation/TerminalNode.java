package representation;

/**
 * Un node terminal est un noeud qui n'a pas de fils Ce type de noeud indique la
 * fin de jeu
 */
public class TerminalNode extends Node {

	public TerminalNode(String description) {
		super(description);
	}
	
	@Override
	public Node chooseNext() {
		return this;
	}

}
