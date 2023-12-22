/* package vue;

import java.util.Scanner;

import org.fusesource.jansi.Ansi;


public class UITexteColore implements UI{
	
	private static Scanner scanner = new Scanner(System.in);

	@Override
	public void afficher(String texte) {
        //AnsiConsole.systemInstall();

        System.out.println(Ansi.ansi().fg(Ansi.Color.CYAN).a(texte).reset());
        //System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).a("This is green text").reset());
        //System.out.println(Ansi.ansi().fg(Ansi.Color.BLUE).a("This is blue text").reset());

        // Reset Jansi after using it
        //AnsiConsole.systemUninstall();
		//System.out.println("Graphique:"+texte);
		
	}

	@Override
	public String lire(String label) {
        System.out.println(Ansi.ansi().fg(Ansi.Color.RED).a(label).reset());
		String choix = scanner.next();
		return choix;
	}

}
*/