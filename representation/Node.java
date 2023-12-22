package representation;

import java.io.Serializable;
import java.util.List;

/**
 * Classe abstraite qui d�finit un noeud basique
 *
 */
public abstract class Node  implements Event, Serializable {
	/**
	 * Compteur qui permet d'affecter un identifiant � chaque noeud
	 */
	private static int compteur = 1;

	/**
	 * Identifiant du noeud
	 */
	protected int id;

	/**
	 * Description du noeud
	 */
	protected String description;

	/**
	 * 
	 */
	public Node(String description) {
		this.description=description;
		this.id = compteur++;
	}

	/**
	 * Affiche la description du noeud
	 */
	public void display() {
		System.out.println(this.description);
	}

	/**
	 * Choisir le noeud suivant Le choix est d�finit par une impl�mentation de cette
	 * m�thode
	 * 
	 * @return
	 */
	public abstract Node chooseNext();
	
	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
