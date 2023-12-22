package univers;

import java.util.Scanner;

import vue.UI;

public class CourseMontre extends Epreuve{
	
	String phrase;
	int delaiMax;
	long tempsDepart;
	long tempsFin;
	String phraseSaisie;
	
	
	private static Scanner scanner = new Scanner(System.in);


	public CourseMontre(String phrase, int delaiMax) {
		super();
		this.phrase = phrase;
		this.delaiMax = delaiMax;
		phraseSaisie="";
	}

	@Override
	public void demarrer(UI ui) {
		ui.afficher("Prépare-toi pour un défi de rapidité contre la montre. Tape la phrase suivante avant que le délai ne s'épuise, mais fais attention, Gabin pourrait bien te devancer !");
		ui.afficher("Appuyez sur Entrer pour commencer");
		scanner.nextLine();
		ui.afficher("VOUS AVEZ "+delaiMax+" SECONDES POUR ECRIRE LA PHRASE CI-DESSOUS :");	
		ui.afficher(phrase);
		tempsDepart=System.currentTimeMillis();
		
	}

	@Override
	public void jouer(UI ui) {
		phraseSaisie = scanner.nextLine();
		tempsFin=System.currentTimeMillis();
	}

	@Override
	public boolean aGagner(UI ui) {
		if (phraseSaisie.equals(phrase))
		{
			if ((tempsFin-tempsDepart)<=delaiMax*1000)
			{
				ui.afficher("Bravo, tu as surpassé Gabin et remporté la victoire ! Un triomphe épique dans cette course effrénée contre le guépard sauvage !");
				return true;
			}
			else 
			{
				ui.afficher("Hélas, le temps s'est déjà écoulé. Le défi reste irrésolu cette fois-ci. Fais vite ton prochain choix avant que Gabin ne te saute dessus et te dévore ");
				return false;
			}
		}
		else 
		{
			ui.afficher("Malheureusement, tu as perdu. La phrase est incorrecte cette fois-ci. Fais vite ton prochain choix avant que Gabin ne te saute dessus et te dévore");
			return false;
		}
	}
	
	@Override
	public int coutPointsVie() {
		if (phraseSaisie.equals(phrase))
	{
		if ((tempsFin-tempsDepart)<=delaiMax*1000)
			return 0; }
				return -25;
			}
	}

