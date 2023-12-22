package vue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Cette classe n'est pas intéressante dans ce cas car nous n'avons pas réussi à finaliser le mode couleur 
public class FabriqueUI {
	
	private static UI ui;
	
	private static List<String> modesDisponibles = new ArrayList<>(Arrays.asList(new String[] {"texte"})); // ,"couleur" mais non disponible 

	public static  List<String> getUIDisponibles()
	{
		return modesDisponibles;
	}
	
	public static void creerUI(String typeUI)
	{
		System.out.println("Fabrique de Mode du jeu:"+typeUI);

		if (typeUI.equals("texte"))
			ui=new UITexte();
		// else  ui=new UITexteColore();		
	}
	
	public static UI getUI() {
		if (ui==null)
			creerUI("texte");
		return ui;
	}

}
