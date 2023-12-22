package representation;

import java.util.Random;
import java.util.Scanner;

import univers.ChoixSimple;
import univers.Epreuve;
import vue.FabriqueUI;
import vue.UI;

/**
 * Un noeud de type 'Decision' Il s'agit d'un noeudpour lequel le choix du noeud
 * suivant est fait par le joueur
 *
 */

public class DecisionNode extends InnerNode {

	Epreuve defi;

	private Random random = new Random();

	public DecisionNode(String description, Epreuve defi) {
		super(description);
		this.defi = defi;
	}

	@Override
	public Node chooseNext() {
		int choix;
		UI ui = FabriqueUI.getUI();
		defi.demarrer(ui);
		defi.jouer(ui);
		boolean defiResolu = defi.aGagner(ui);

		// s'il resoud le defi, il a le droit de choisir la prochaine etape
		if (defiResolu) {

			if (nextNodes.size() > 1) {
				ui.afficher("Choisis ta prochaine destination !");
				
			/*for (Node node : nextNodes) {
					ui.afficher(node.getDescription());
*/
				if ((defi instanceof ChoixSimple))
					choix = Integer.parseInt(ui.lire("Donner le numéro de votre choix:"));
				else choix = Integer.parseInt(ui.lire("Donner le numéro de votre choix (1.."+nextNodes.size() +"):"));
			} else
				choix = 1;
			return nextNodes.get(choix - 1);
		} else {
			ui.afficher(
					"\n \t Maintenant, direction une destination inconnue, choisie au hasard par les forces mystérieuses de ce monde fantastique. LA VOICI :");
			int randomIndex = random.nextInt(nextNodes.size());
			return nextNodes.get(randomIndex);
		}

	}

	@Override
	public void display() {
		UI ui = FabriqueUI.getUI();
		ui.afficher(toString());
	}

	@Override
	public String toString() {
		return description;
	}

	public Epreuve getEpreuve() {
		return defi;
	}

}
