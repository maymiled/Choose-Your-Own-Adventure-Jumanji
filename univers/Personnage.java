package univers;

import java.io.Serializable;

/**
 * Classe de base pour les personnages L'utilisateur choisit ensuite un
 * personnage entre le zoologiste, le cartographe et l'aventurier Chacun des
 * personnages a des caract�ristiques qui lui sont propres et des armes qui
 * diff�rent
 *
 */

public class Personnage implements Serializable{

	private String nom;
	
	private int pointsDeVie;
	

	private String description;
	

	public Personnage(String nom, String description, int pointsDeVie) {
		this.nom = nom;
		this.pointsDeVie = pointsDeVie;
		this.description = description;
	}


	@Override
	public boolean equals(Object obj) {
		return this.nom.equals(((Personnage) obj).getNom());
	}

	// M�thodes abstraites possibles
	// public abstract void attaquer();
	// public abstract void d�fendre();
	// public abstract void utiliserObjet();

	@Override
	public String toString() {
		return "Personnage [nom=" + nom + ", pointsDeVie=" + pointsDeVie + ", description=" + description + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPointsDeVie() {
		return pointsDeVie;
	}

	public void setPointsDeVie(int pointsDeVie) {
		this.pointsDeVie = pointsDeVie;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}