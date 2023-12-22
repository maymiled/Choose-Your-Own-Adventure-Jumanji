package univers;

import java.util.ArrayList;
import java.util.Random;

public class BanqueEnigme {

	private ArrayList<Enigme> enigmes;
	private Random random;

	public BanqueEnigme() {
		enigmes = new ArrayList<>();
		random = new Random();
		Enigme enigme;

// on peut plus tard immaginer un fichier de donner JSON pour stoquer les donnees de la banque d'enigme
		ArrayList<String> reponse1 = new ArrayList<>();
		reponse1.add("1-de programmation procedural");
		reponse1.add("2-de programmation fonctionnel");
		reponse1.add("3-de programmation script");
		reponse1.add("4-de programmation OOP");
		enigme = new Enigme("Le langage Java est un langage ?", reponse1, 4);
		enigmes.add(enigme);

		ArrayList<String> reponse2 = new ArrayList<>();
		reponse2.add("1-Tigre");
		reponse2.add("2-Lion");
		reponse2.add("3-Serpent");
		reponse2.add("4-Gorille");
		enigme = new Enigme("Au cœur de la jungle, je suis roi,\n" + "Avec ma crinière, je brille de foi.\n"
				+ "Féroce et puissant, dans l'ombre je rampe,\n" + "Qui suis-je parmi ces créatures de la pampa?",
				reponse2, 2);
		enigmes.add(enigme);

		ArrayList<String> reponse3 = new ArrayList<>();
		reponse3.add("1-L'ombre");
		reponse3.add("2-Le reflet");
		reponse3.add("3-soi-même");
		reponse3.add("4-La vue");
		enigme = new Enigme(
				"Dans le miroir, je ne suis pas en avant. Je suis derrière le monde entier. Qu'est-ce que je suis ?",
				reponse3, 2);
		enigmes.add(enigme);

		ArrayList<String> reponse4 = new ArrayList<>();
		reponse4.add("1-Quelle porte le menteur indiquerait comme la bonne ?");
		reponse4.add("2-Si je demandais à un autre gardien, quelle porte choisirait-il ?");
		reponse4.add("3-Quelle est la porte que vous protégez, gardien honnête ?");
		reponse4.add("4-Quelle porte l'autre gardien pointerait-il comme la porte menant au trésor ?");
		enigme = new Enigme("Quatre gardiens protègent quatre portes. "
				+ "Chacun dit une vérité et une seule ment. Une porte mène au trésor. \n"
				+ "Quelle question poseriez-vous pour trouver la bonne porte ?", reponse4, 4);
		enigmes.add(enigme);

		ArrayList<String> reponse5 = new ArrayList<>();
		reponse5.add("1-Alternance de couleurs (ABCABC)");
		reponse5.add("2-Toutes les pierres sont de la même couleur.");
		reponse5.add("3-Deux pierres consécutives ont la même couleur.");
		reponse5.add("4-Une pierre est entourée de pierres de couleurs différentes.");
		enigme = new Enigme(
				" \"Six pierres précieuses sont disposées en cercle. Chaque pierre est d'une couleur différente. \n"
						+ "Si deux pierres voisines partagent la même couleur, la troisième pierre entre elles est d'une autre couleur. \n"
						+ "Comment sont disposées les pierres ?",
				reponse5, 1);
		enigmes.add(enigme);

		ArrayList<String> reponse6 = new ArrayList<>();
		reponse6.add("1- 6 mètres. (Les espaces entre les planches ne sont pas additionnés.)");
		reponse6.add("2- 5 mètres (comptant seulement les planches).");
		reponse6.add("3- 12 mètres (comptant les espaces entre les planches).");
		reponse6.add("4- 0 mètre (les planches ne sont pas réelles).");
		enigme = new Enigme(
				"Sur un pont, il y a six planches. Si chaque planche occupe 1 mètre, et chaque espace entre les planches occupe 1 mètre. \n"
						+ "quelle est la longueur totale du pont ?",
				reponse6, 1);
		enigmes.add(enigme);

		ArrayList<String> reponse7 = new ArrayList<>();
		reponse7.add("1- Alligator");
		reponse7.add("2- Crocodile");
		reponse7.add("3- Iguane");
		reponse7.add("4- Caméléon");
		enigme = new Enigme(
				"Cachée dans l'eau, ma peau est une armure,\n" + "Je me déplace sans bruit, avec une allure.\n"
						+ "Mâchoires puissantes, danger à toute heure,\n" + "Quel reptile suis-je, symbole de frayeur?",
				reponse7, 2);
		enigmes.add(enigme);

		ArrayList<String> reponse8 = new ArrayList<>();
		reponse8.add("1- Caméléon");
		reponse8.add("2- Crocodile");
		reponse8.add("3- Python");
		reponse8.add("4- Grenouille");
		enigme = new Enigme(
				"Sous les feuilles, je me dissimule,\n" + "Ma peau change, c'est une camisole.\n"
						+ "Venin mortel, en silence je rampe,\n" + "De quel reptile suis-je la contrepèterie?",
				reponse8, 3);
		enigmes.add(enigme);

		ArrayList<String> reponse9 = new ArrayList<>();
		reponse9.add("1- Elephant");
		reponse9.add("2- Gorille");
		reponse9.add("3- Tigre");
		reponse9.add("4- Serpent");
		enigme = new Enigme("Au cœur de Jumanji, je rugis,\n" + " Avec des crocs acérés, je surgis.\n"
				+ " Félin puissant, dans l'ombre je me cache,\n" + " Qui suis-je parmi ces choix qui s'attachent?",
				reponse9, 3);
		enigmes.add(enigme);

		ArrayList<String> reponse10 = new ArrayList<>();
		reponse10.add("1- Marco Polo");
		reponse10.add("2- Indiana Jones");
		reponse10.add("3- Vasco de Gama");
		reponse10.add("4- Ferdinand Magellan");
		enigme = new Enigme(
				"Sur la carte ancienne, mon emplacement est flou, \n"
						+ "Des temples perdus, un trésor sous la poussière de vieux bijoux."
						+ "Navigateur intrépide, suivez mon sillage doux," + "Quel aventurier légendaire êtes-vous?",
				reponse10, 2);
		enigmes.add(enigme);

	}

	public Enigme getRandomEnigme() {
		return enigmes.get(random.nextInt(enigmes.size()));
	}

}