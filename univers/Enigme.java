package univers;

import java.util.ArrayList;

import vue.UI;

public class Enigme extends Epreuve{
	
	String question;
	ArrayList<String> reponses;
	public int indiceRepCorr;
	public int reponseUtilisateur;
	
	

	public Enigme(String question, ArrayList<String> reponses, int indiceRepCorr) {
		this.question = question;
		this.reponses = reponses;
		this.indiceRepCorr = indiceRepCorr;
	}

	@Override
	public void demarrer(UI ui) {
		ui.afficher(question);
		for(String reponse:reponses)
			ui.afficher(reponse);		
	}

	@Override
	public void jouer(UI ui) {
		reponseUtilisateur=Integer.parseInt(ui.lire("Donnez le numero de votre choix (de 1 a 4):"));
	}

	@Override
	public boolean aGagner(UI ui) {
		if (reponseUtilisateur==indiceRepCorr) {
			ui.afficher("\n \t Bravo, intrépide aventurier ! Tu as résolu l'énigme de Lulu le Lutin avec brio. \n \t Ta sagacité te permet désormais de choisir ta prochaine destination dans cette jungle mystérieuse. \n \t Où désires-tu te diriger pour la suite de ton aventure ?");
			return true;}
		else 
		{
			ui.afficher( "\t Lulu le Lutin te regarde d'un air déçu. \n \t Les yeux plissés, il secoue la tête et murmure 'Oh non, tu as mal répondu à mon énigme, aventurier'. ");
			return false;
		}
	}
	
	
	@Override
	public int coutPointsVie() {
		return -20;
	}

}
