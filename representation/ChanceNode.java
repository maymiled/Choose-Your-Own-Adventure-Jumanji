package representation;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Un noeud de type 'Chance' Il s'agit d'un noeud de d�cision mais le choix est
 * fait al�atoirement
 *
 */
public class ChanceNode extends InnerNode  {
	/**
	 * Permet de choisir un chiffre au hasard
	 * 
	 */
	private int coutPointVie;
	
	private static Scanner scanner = new Scanner(System.in);

	private Random random = new Random();
	
	public ChanceNode(String description) {
		super(description);
		this.coutPointVie=0;
	}
	
	public ChanceNode(String description, int coutPointVie) {
		super(description);
		this.coutPointVie=coutPointVie;
	}

	@Override
	public Node chooseNext() {
		try {
			System.in.read();
			scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int randomIndex = random.nextInt(nextNodes.size());
		return nextNodes.get(randomIndex);
	}

	@Override
	public void display() {
		System.out.println(description
				+ " \n \t Appuie frénétiquement sur une touche, aventurier, car le destin capricieux de ce monde fantastique t'attend au détour de chaque pression de clavier !");
	}
	
	public int getCoutPointVie() {
		return coutPointVie;
	}

}
