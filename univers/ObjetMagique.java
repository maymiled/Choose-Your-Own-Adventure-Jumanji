package univers;

/**
 * Classe repr�sentant un objet Magique utilis� par un personnage
 *
 */
public class ObjetMagique {
	/**
	 * Nom de l'objet
	 */
	private String nom;

	/**
	 * Description de l'objet
	 */
	private String description;

	/**
	 * Tye de l'objet
	 */
	private TypeObjetMagique type;

	/**
	 * 
	 * @param nom
	 * @param description
	 */
	public ObjetMagique(String nom, String description) {
		this.setNom(nom);
		this.setDescription(description);
	}

	/**
	 * 
	 */
	public void activer() {
		// Implémenter l'activation de l'objet magique
	}

	/**
	 * 
	 */
	public void desactiver() {
		// Implémenter la désactivation de l'objet magique
	}

	public String getNom() {
		return nom;
	}

	public TypeObjetMagique getType() {
		return type;
	}

	public void setType(TypeObjetMagique type) {
		this.type = type;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object obj) {
		return this.nom.equals(((ObjetMagique) obj).getNom());
	}

	@Override
	public String toString() {
		return "Object Magique [" + this.nom + "]";
	}

}
