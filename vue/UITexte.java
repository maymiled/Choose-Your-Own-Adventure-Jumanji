package vue;

import java.util.Scanner;

public class UITexte implements UI{
	
	private static Scanner scanner = new Scanner(System.in);

	@Override
	public void afficher(String texte) {
		System.out.println(texte);
		
	}

	@Override
	public String lire(String label) {
		System.out.print(label);
		String choix = scanner.next();
		return choix;
	}

}
