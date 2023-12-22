package univers;

import java.util.Random;

import vue.UI;

public class BouleMagique extends Epreuve{
	private int coutPointsVie;
	
	public BouleMagique()
	{
		Random random = new Random();
		coutPointsVie = random.nextInt(-20,20);
		
	}

	@Override
	public void demarrer(UI ui) {
		ui.afficher("Devant toi se tient le volcan, et tu as clairement choisi de ramasser l'une de ses boules de feu magiques.");
		
	}

	@Override
	public void jouer(UI ui) {
		ui.lire("Appuie sur une touche du clavier pour l'ouvrir et voir les mystères qu'elle te réserve. Que la chance soit avec toi...  ");
		if (coutPointsVie==0)
			ui.afficher("Plus de peur que de mal, tu ne gagnes rien cette fois mais tu ne perds rien non plus ");
		if (coutPointsVie>0)
			ui.afficher("Chanceux, tu gagnes " + coutPointsVie +" points de vie supplémentaires");				
		if (coutPointsVie<0)
			ui.afficher("Quel dommage... Ta chance n'a pas été de ton côté aujourd'hui. Tu perds  " + coutPointsVie +" points de vie. Ré-essaie une prochaine fois!");
	}

	@Override
	public boolean aGagner(UI ui) {
		
		return (coutPointsVie>=0);
	}

	@Override
	public int coutPointsVie() {
		return coutPointsVie;
	}

}
;