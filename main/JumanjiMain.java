package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import data.SaveData;
import representation.Game;
import representation.SoundNode;
import vue.FabriqueUI;
import representation.ChanceNode;
import representation.FabriqueVideotheque;




/**
 * Class main permettant de lancer le jeux
 *
 */
public class JumanjiMain {

	/**
	 * Scanner qui permet de lire une entr�e saisie par le joueur
	 */
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * M�thode principale
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Game game;
		
				
		System.out.println("\tBienvenue dans votre jeu :");
		System.out.println("      _ _   _ __  __    _    _   _     _ ___ ");
		System.out.println("     | | | | |  \\/  |  / \\  | \\ | |   | |_ _| ");
		System.out.println("  _  | | | | | |\\/| | / _ \\ |  \\| |_  | || | ");
		System.out.println(" | |_| | |_| | |  | |/ ___ \\| |\\  | |_| || | ");
		System.out.println("  \\___/ \\___/|_|  |_/_/   \\_\\_| \\_|\\___/|___| ");		
		
				
		if (recupererChoixCharger())
		{
			game = chargerJeuxPrecedant();
		}
		else {
			String nomJoueur = recupererNomJoueur();
			String titreJeu=choisirTitreJeu();
			String mode = choisirMode();				
			game  = new Game(nomJoueur,titreJeu,mode);	
			game.setDateDebut(new Date());
		}
					
		System.out.println("Le jeu va commencer ...");
		game.start();
	}
	
	public static boolean recupererChoixCharger() {
		List<Game> savedGames = SaveData.loadGame();
		if (savedGames.size()==0)
			return false;
		System.out.print("Voulez vous reprendre une ancienne session de jeux (o/n)? :");
		String choix = scanner.next();
		return choix.equals("o");
	}
	
	public static Game chargerJeuxPrecedant()
	{
		List<Game> savedGames = SaveData.loadGame();
		
		if (savedGames.size()==1)
			return savedGames.get(0);
		
		int choix=1;
		System.out.println("\n \t Choisir une des sessions suivantes:");
		for(Game game: savedGames)
		{
			System.out.println("\t" + choix + "- Session de "+ game.getDateDebut());
			choix++;
		}		
		do 
		{
			System.out.print("Numero de session :");
			choix = Integer.parseInt(scanner.next());
			
		} while (choix<1 || choix >savedGames.size());
		
		return savedGames.get(choix-1);	
		
	}

	/**
	 * Choisir le personnage du jeu
	 * 
	 * @param nomJoueur alias du joueur
	 * @return Le personnage choisi
	 */
	
	private static String choisirTitreJeu()
	{
		List<String> titresDisponibles = new ArrayList<>(Arrays.asList(FabriqueVideotheque.getTitreDisponibles()));
		String choix; 
		System.out.println("                     Bienvenue dans le monde fantastique de Jumanji !\r \n"
				+ "                     Tu te tiens à l'orée d'une forêt dense et mystérieuse.  \r\n"
				+ "                     Les arbres gigantesques s'élèvent au-dessus de toi, leurs feuilles crépitant \r\n"
				+ "                     comme si elles murmuraient des secrets anciens. L'air est chargé de magie et \r\n"
				+ "                     le sol résonne des bruits mystiques de créatures inconnues. \r\n"
				+ "                     Devant toi, le sentier de la destinée se divise en trois. Choisis avec sagesse \r\n"
				+ "                     car chaque chemin t'entraînera vers une aventure unique et pleine de défis. \n \n"
				+ "Pour débuter ton aventure, il sera crucial de choisir ton personnage en fonction des traits de personnalités qui te semblent les plus adaptés.\n"
				+ "Voici deux propositions : ");
		int choix_menu=1;
		for(String titre: titresDisponibles)
		{
			System.out.println("\t"+choix_menu+"-"+titre);
			choix_menu++;
		}
		do 
		{
			System.out.println(" \t ");
			System.out.print("Dans la peau de quelle personnage souhaites-tu te glisser ?  ");
			choix_menu = Integer.parseInt(scanner.next())-1;
			
		} while (!titresDisponibles.contains(titresDisponibles.get(choix_menu)));
		
		return titresDisponibles.get(choix_menu);
		
	}
	
	private static String choisirMode()
	{
		List<String> modesDisponibles = FabriqueUI.getUIDisponibles();
				
		String choix; 
		System.out.println("\n \t Espérons que tu aies fait le bon choix... Quel mode de jeu te semble le plus adapté à ton aventure ?");
		for(String titre: modesDisponibles)
		{
			System.out.println("\t" + titre );
		}
		
		do 
		{
			System.out.print("Dis nous tout :");
			choix = scanner.next();
			
		} while (!modesDisponibles.contains(choix));
		
		return choix;
		
	}
	

	/**
	 * Demander au joueur de saisir un alias
	 * 
	 * @return L'alias saisi par le joueur
	 */
	private static String recupererNomJoueur() {
		System.out.println("");
		System.out.println("\tVeuillez saisir votre nom !");

		String choix = scanner.next(); // user's choice

		return choix;
	}

}

