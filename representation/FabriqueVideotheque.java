package representation;

import java.util.ArrayList;
import java.util.List;
import univers.*;

public class FabriqueVideotheque {

	private static String[] titresJeu = new String[] { "Aventurier", "Intelligent" };

	public static Graph creerInstance(String titreJeu) {

		if (titreJeu.equals("Aventurier"))
			return creerJeuAventurier();

		if (titreJeu.equals("Intelligent"))
			return creerJeuIntelligent();

		return null;

	}

	public static String[] getTitreDisponibles() {
		return titresJeu.clone();
	}

	/*
	 * 
	 * 1->2 1: titre du 2
	 * 
	 * 3->2 3: titre de 2
	 *
	 * 
	 */

	private static Graph creerJeuIntelligent() {
		BanqueEnigme banqueEnigme = new BanqueEnigme();
		CourseMontre courseMontre = new CourseMontre("mon projet est le meilleur", 8);
		CourseMontre courseMontre2 = new CourseMontre("je cours plus vite que le guepard", 10);
		List<Node> nodes = new ArrayList<>();
		List<String> liste_img = new ArrayList<>();
		liste_img.add("./src/photoJumanji.jpg");
		liste_img.add("./src/photoJumanji2.jpg");
		List<String> liste_img2 = new ArrayList<>();
		liste_img2.add("./src/Jumanji_Lion.jpg");

		DecisionNode node00 = new DecisionNode(
				"\n \t Bienvenue, intrépide aventurier, dans cette jungle pleine de mystères. Ton désir ardent : échapper vivant de cet endroit sauvage.\n"
						+ "Tu peux choisir entre trois directions à explorer :\n\n"
						+ "1. Suivre le sentier lumineux vers la \"Clairière d'Émerveillement\" .\n"
						+ "2. S'aventurer dans l'obscurité dense vers le \"Canyon Sombre\" .\n"
						+ "3. Grimper aux arbres pour atteindre la \"Canopée Céleste\" .",
				new ChoixSimple());
		
		SoundNode node0 = new SoundNode(node00,"./src/Jumanji Soundtrack - Jumanji Theme.wav");
		

		DecisionNode node999 = new DecisionNode(
				"Dans la clairière, tu rencontre Sylvanis qui te félicite et propose trois choix :\n\n"
						+ "1. S'entraîner avec des créatures magiques dans la \"Clairière d'Entraînement\" .\n"
						+ "2. Récupérer des artefacts puissants dans la \"Grotte des Trésors\" .\n"
						+ "3. Ignorer Sylvanis et se confronter aux énigmes du pont gardé par Lulu Le Lutin.",
				new ChoixSimple());
		
		
		// Supposons que vous ayez déjà une classe ImageNode similaire à SoundNode
		ImageNode node1 = new ImageNode(node999, liste_img);

		DecisionNode node2 = new DecisionNode(
				"Te voilà face à un canyon sombre. Malheureusement, celui-ci est rempli de dangers. Tu perds quelques points de vies. \n"
						+ "Deux options s'offrent à toi :\n\n"
						+ "1. Utiliser une torche pour explorer les \"Grottes Luminescentes\" .\n"
						+ "2. Tenter de traverser le \"Pont Fragile\" en équilibre .\n",
				new ChoixSimple(-10));

		DecisionNode node3 = new DecisionNode("Dans la Canopée Céleste, tu découvres des choix supplémentaires :\n\n"
				+ "1. Rencontrer une tribu d'elfes magiques dans la \"Cité Suspendue\".\n"
				+ "2. Trouver un passage secret vers la \"Vallée des Esprits Anciens\".\n"
				+ "3. Utiliser une liane pour descendre vers le \"Lac des Reflets\".", new ChoixSimple());

		DecisionNode node4 = new DecisionNode("Dans la clairière d'entraînement, tu peux :\n\n"
				+ "1. Améliorer tes compétences magiques avec le \"Sorcier Sage\".\n"
				+ "2. Affronter des monstres dans l'\"Arène Mystique\".\n", new ChoixSimple());

		DecisionNode node5 = new DecisionNode(
				"Tu découvres une grotte remplie de trésors et dois faire un choix :\\n\\n\"\n"
						+ "                        1. Prendre la \"Couronne des Rois\". \n"
						+ "                        2. Prendre l'\"Épée de l'Ancien Héros\".\n"
						+ "                        3. Prendre la \"Boussole des Destinées\".",
				new ChoixSimple());

		DecisionNode node6 = new DecisionNode("\n Direction le pont où Lulu le Lutin t'attend. \n"
				+ " \t Pour traverser et poursuivre ton aventure, tu devras répondre correctement à son énigme.",
				banqueEnigme.getRandomEnigme());

		DecisionNode node7 = new DecisionNode(
				"Tu as peut être perdu un peu de temps en allant rendre visite au sorcier mais tu as surtout gagné de la sagesse. \n"
						+ " Voici 10 points de vie pour te féliciter. En sortant de la cabane du sorcier, clique sur une touche pour voir là où il te conseille d'aller : le canopée",
				new ChoixSimple(10));

		DecisionNode node8 = new DecisionNode(
				"Tu te retrouves face à un volcan explosif d'où jaillissent des boules de feu. \n"
						+ "Tu as l'opportunité de ramasser une de ces boules, mais la question demeure : cela te sera-t-il bénéfique ?",
				new BouleMagique());

		DecisionNode node9 = new DecisionNode("Te voilà dans les grottes luminescentes, tu peux : \n\n \n"
				+ "                        1. Suivre la lueur des \"Cristaux Magiques\" pour trouver une sortie.\n"
				+ "                        2. Rencontrer des \"Chauves-Souris Géantes\" qui peuvent être amicales ou hostiles ",
				new ChoixSimple());

		ChanceNode node10 = new ChanceNode("Tu te tiens sur un pont fragile en équilibre. \n"
				+ "Bonne chance car tu peux le traverser avec précaution et continuer ton aventure ou risquer une chute et perdre des points de vie.");

		DecisionNode node11 = new DecisionNode("Le pont n'a pas été ton fort, c'est dommage!\n"
				+ " Tappe sur ton clavier pour essayer de te rattraper avec cette prochaine épreuve de rapidité contre la montre, attention tu es face à Gabin, guépard affamé!",
				new ChoixSimple(-20));

		DecisionNode node12 = new DecisionNode("Bravo à toi vaillant aventurier! \n"
				+ " Continue de faire tes preuves avec cette prochaine épreuve de rapidité contre la montre, attention tu es face à Gabin, guépard affamé!",
				new ChoixSimple());

		DecisionNode node133 = new DecisionNode("Après avoir consulté le Sorcier Sage, tu ressens un regain d'énergie."
				+ "\t Il te donne 10 points de vie pour affronter la prochaine épreuve : la rencontre avec Gabin le Guépard. Clique sur une touche pour y aller plus fort que jamais!",
				new ChoixSimple(10));
		
		ImageNode node13 = new ImageNode(node133,liste_img2);
		DecisionNode node144 = new DecisionNode(
				"\t Prépare-toi pour un défi de rapidité contre la montre. \n \tTape la phrase suivante avant que le délai ne s'épuise, mais fais attention, Gabin pourrait bien te devancer !",
				courseMontre);
		SoundNode node14 = new SoundNode(node144,"./src/RUGISSEMENT du LION en COLERE.wav");

		ChanceNode node15 = new ChanceNode(
				"\t Laisse le hasard guider ton destin car dans la cité suspendu, ce n'est plus toi qui est maitre de ce dernier."
						+ "\t Iras-tu vers une course effrenée contre un guépard affamé ou ramasseras-tu une boule de feu du volcan ? ",
				0);

		DecisionNode node16 = new DecisionNode(
				"Tu te retrouves face à un volcan explosif d'où jaillissent des boules de feu. \n"
						+ "Tu as l'opportunité de ramasser une de ces boules, mais la question demeure : cela te sera-t-il bénéfique ?",
				new BouleMagique());

		DecisionNode node17 = new DecisionNode(
				"La vallée des esprits anciens te mène sans plus attendre vers un volcan agité...  \n",
				new ChoixSimple());

		DecisionNode node18 = new DecisionNode(
				"Sur ce lac reflète clairement ton avenir : une course contre un guépard affamé t'attend... \n"
						+ "Saisis vite une lettre sur ton clavier!",
				new ChoixSimple());

		ChanceNode node19 = new ChanceNode(
				"\t Règle d'or dans Jumanji : Ne jamais voler aucun objet, sous peine de perdre des points de vie. \n "
						+ "Tu te retrouves immédiatement lancé dans une course effrénée contre Gabin le Guépard.",
				-20);

		DecisionNode node20 = new DecisionNode(
				"Tu ne vas quand même pas t'échapper sans rendre visite à Gabin le Guépard...\n"
						+ "Saisis 'go' pour démarrer une course contre la montre contre un guépard affamé...",
				courseMontre2);

		ChanceNode node21 = new ChanceNode(
				"\t Quelle idée que de combattre avec si peu d'entrainement! Tu ne risques pas de sortir vivant toi...",
				-25);

		ChanceNode node22 = new ChanceNode(
				"\t Voyons voir si les chauves souris ont décidé d'être de gentilles créatures aujourd'hui", 0);

		DecisionNode node23 = new DecisionNode(
				"\t Tu as su les dompter. Sylvanis est vraiment impressioné! \n"
						+ "Tu te diriges maintenant vers un mystérieux volcan... Saisis 'go' pour y aller ",
				new ChoixSimple());

		DecisionNode node24 = new DecisionNode(
				"\t Tu ne tires donc aucune leçon du Covid ? Les chauves-souris ne sont pas des animaux de confiance \n"
						+ "Tu te diriges maintenant vers un mystérieux volcan...",
				new ChoixSimple());

		ChanceNode node25 = new ChanceNode(
				"\t Règle d'or dans Jumanji : Ne jamais voler aucun objet, sous peine de perdre des points de vie. \n "
						+ "Tu te retrouves immédiatement lancé dans une course effrénée contre Gabin le Guépard.",
				-20);

		DecisionNode node26 = new DecisionNode(
				"De retour au pont de Lulu le Lutin, tu te tiens devant le passage délicat. Lulu t'observe, prêt à te poser une dernière énigme redoutable.",
				banqueEnigme.getRandomEnigme());

		DecisionNode node27 = new DecisionNode(
				"Tu te retrouves à la lisière de la jungle, face à deux chemins mystérieux. Chacun semble mener vers un destin différent :\n\n"
						+ "1. Emprunter le \"Sentier de la Lueur Éthérée\" .\n"
						+ "2. S'aventurer dans la \"Forêt des Ombres Profondes\" .",
				new ChoixSimple());

		DecisionNode node28 = new DecisionNode("C'est ici que s'achève ton aventure! \n "
				+ "Jeune aventurier, si ce message s'affiche, c'est que tu as réussi a sortir sain et sauf de la jungle et tu peux être fier de toi! Ce n'était pas facile ! ",
				new ChoixSimple());

		DecisionNode node29 = new DecisionNode(
				"Il s'agit là d'un chemin rempli d'embuches et bien plus long... Tu y perds quelques points de vie... \n "
						+ "Toi qui aime le risque, pourquoi ne pas ouvrir une nouvelle boule magique ?",
				new ChoixSimple(-5));

		TerminalNode node30 = new TerminalNode("FIN");

		nodes.add(node0);
		nodes.add(node1);// 0
		nodes.add(node2);// 1
		nodes.add(node3);// 2
		nodes.add(node4);// 3
		nodes.add(node5);// 4
		nodes.add(node6);
		nodes.add(node7);
		nodes.add(node8);
		nodes.add(node9);
		nodes.add(node10);
		nodes.add(node11);
		nodes.add(node12);
		nodes.add(node13);
		nodes.add(node14);
		nodes.add(node15);
		nodes.add(node16);
		nodes.add(node17);
		nodes.add(node18);
		nodes.add(node19);
		nodes.add(node20);
		nodes.add(node21);
		nodes.add(node22);
		nodes.add(node23);
		nodes.add(node24);
		nodes.add(node25);
		nodes.add(node26);
		nodes.add(node27);
		nodes.add(node28);
		nodes.add(node29);
		nodes.add(node30);
// 0 -> (1,2)
// 1 -> (3)
// 2 -> (3,4)
// 3 -> (6)
// 4 -> (5)
// 5 -> (6)

// int connexion[][]=new int [][] {
// {0,1,1,0,0,0,0},
// {0,0,0,1,0,0,0},
// {0,0,0,1,1,0,0},
// {0,0,0,0,0,0,1},
// {0,0,0,0,0,1,0},
// {0,0,0,0,0,0,1},
// {0,0,0,0,0,0,0}
// };

		int connexion[][] = new int[nodes.size()][nodes.size()];
		for (int i = 0; i < nodes.size(); i++)
			for (int j = 0; j < nodes.size(); j++)
				connexion[i][j] = 0;
		connexion[0][1] = 1;
		connexion[0][2] = 1;
		connexion[0][3] = 1;
		connexion[1][4] = 1;
		connexion[1][5] = 1;
		connexion[1][6] = 1;
		connexion[2][9] = 1;
		connexion[2][10] = 1;
		connexion[3][15] = 1;
		connexion[3][17] = 1;
		connexion[3][18] = 1;
		connexion[5][19] = 1;
		connexion[5][25] = 1;
		connexion[4][7] = 1;
		connexion[4][21] = 1;
		connexion[6][3] = 1;
		connexion[7][3] = 1;
		connexion[10][11] = 1;
		connexion[10][12] = 1;
		connexion[11][14] = 1;
		connexion[12][14] = 1;
		connexion[13][14] = 1;
		connexion[10][13] = 1;
		connexion[11][13] = 1;
		connexion[12][13] = 1;
		connexion[15][16] = 1;
		connexion[15][14] = 1;
		connexion[17][16] = 1;
		connexion[18][14] = 1;
		connexion[13][14] = 1;
		connexion[9][20] = 1;
		connexion[9][22] = 1;
		connexion[20][16] = 1;
		connexion[21][5] = 1;
		connexion[21][9] = 1;
		connexion[23][16] = 1;
		connexion[24][16] = 1;
		connexion[19][14] = 1;
		connexion[25][14] = 1;
		connexion[22][23] = 1;
		connexion[22][24] = 1;
		connexion[14][16] = 1;
		connexion[16][26] = 1;
		connexion[26][27] = 1;
		connexion[27][28] = 1;
		connexion[27][29] = 1;
		connexion[28][30] = 1;
		connexion[29][8] = 1;
		connexion[8][26] = 1;

		Graph graph = new Graph(nodes, connexion);

		return graph;

	}

	private static Graph creerJeuAventurier() {
		BanqueEnigme banqueEnigme = new BanqueEnigme();
		List<Node> nodes = new ArrayList<>();
		CourseMontre courseMontre = new CourseMontre("je suis un aventurier plus rapide qu'un guepard", 14);
		CourseMontre courseMontre2 = new CourseMontre("c'est presque fini je vais y arriver", 12);
		List<String> liste_img = new ArrayList<>();
		liste_img.add("./src/photoJumanji.jpg");
		liste_img.add("./src/photoJumanji2.jpg");
		List<String> liste_img2 = new ArrayList<>();
		liste_img2.add("./src/volcan.jpg");

		DecisionNode node00 = new DecisionNode(
				"\n \t Bienvenue, vaillant aventurier, dans cette jungle pleine de mystères. Ton désir ardent : échapper vivant de cet endroit sauvage.\n"
						+ "Tu as choisi le mode 'Aventurier Intrépide', tu commenceras donc ton aventure sans plus attendre par une course contre la montre \n\n"
						+ " Tu te retrouveras sans plus attendre face à Gabin, un guépard affamé, pour qu'il ne te dévore pas, fais preuve de rapidité!",
				courseMontre);
		
		SoundNode node0 = new SoundNode(node00,"./src/Jumanji Soundtrack - Jumanji Theme.wav");

		DecisionNode node111 = new DecisionNode(
				"Tu te retrouves dans la clairière et rencontre Sylvanys, ton mentor pendant cette rude aventure"
						+ "Il te propose trois choix : \n \n "
						+ " 1. S'entraîner avec des créatures magiques dans la \"Clairière d'Entraînement\" .\n\n"
						+ " 2. Récupérer des artefacts puissants dans la \"Grotte des Trésors\" .\n\n"
						+ " 3. Ignorer Sylvanis et se confronter aux énigmes du pont gardé par Lulu Le Lutin.",
				new ChoixSimple());
		
		ImageNode node1 = new ImageNode(node111,liste_img);
		
		
		DecisionNode node2p = new DecisionNode(
				"Tu te retrouves face à un volcan explosif d'où jaillissent des boules de feu. \n"
						+ "Tu as l'opportunité de ramasser une de ces boules, mais la question demeure : cela te sera-t-il bénéfique ?",
				new BouleMagique());
		
		ImageNode node2 = new ImageNode(node2p,liste_img2);

		DecisionNode node3 = new DecisionNode("Dans la clairière d'entraînement, tu peux :\n\n"
				+ "1. Améliorer tes compétences magiques avec le \"Sorcier Sage\".\n"
				+ "2. Affronter des monstres dans l'\"Arène Mystique\".\n", new ChoixSimple());

		DecisionNode node4 = new DecisionNode(
				"Tu découvres une grotte remplie de trésors et dois faire un choix :\\n\\n\"\n"
						+ "                        1. Prendre la \"Couronne des Rois\". \n"
						+ "                        2. Prendre l'\"Épée de l'Ancien Héros\".\n"
						+ "                        3. Prendre la \"Boussole des Destinées\".",
				new ChoixSimple());

		DecisionNode node5 = new DecisionNode("\n Direction le pont où Lulu le Lutin t'attend. \n"
				+ " \t Pour traverser et poursuivre ton aventure, tu devras répondre correctement à son énigme.",
				banqueEnigme.getRandomEnigme());

		ChanceNode node6 = new ChanceNode(
				"C'est une bonne idée de rendre visite au grand Sage mais tu as décidé d'être aventurier téméraire plutôt qu'intelligent pour cette aventure. \n"
						+ "Pour en profiter davantage, le Soricer préfère t'emmener dans une destination mystèrieuse et pleine de secrets... ",
				0);

		ChanceNode node7 = new ChanceNode("C'est parti! Tu es lancé dans un combat contre les monstres de l'Arène"
				+ "Tu es un aventurier téméraire et tu t'es bien entrainé dans l'Arêne, tu devrai réussir, prépare toi et bpnne chance!",
				0);

		DecisionNode node8 = new DecisionNode(
				"La 'Couronne des Rois' est le trésor le plus précieux de cette jungle, il t'offre des points de vie. C'était le meilleur choix!",
				new ChoixSimple(10));

		DecisionNode node9 = new DecisionNode(
				"L'Epée de l'Ancien Héros est un trésor précieux. Sylvanis est décu d'apprendre que tu as osé le voler. Tu perds des points de vie suite à ce choix. de cette jungle, il t'offre des points de vie.",
				new ChoixSimple(-10));

		DecisionNode node10 = new DecisionNode(
				"La Boussole Des Destinées ne t'aidera pas beaucoup pour cette aventure. Ce n'est pas grave, tu continues ta route sans perdre de points",
				new ChoixSimple());

		DecisionNode node11 = new DecisionNode("Trois personnes t'attendent derrière le pont : "
				+ "1. Stella, jeune aventurière coincée dans cette jungle comme toi, elle te propose de continuer ta route avec elle pour vous entraider"
				+ "2. Hanibal, neveu de Salvanys, il te conseille de l'écouter pour tes prochains choix"
				+ "3. Alma, jeune louve qui te propose de te protéger par la suite", new ChoixSimple());

		DecisionNode node12 = new DecisionNode(
				"Epatant ! Tu as réussi à vaincre tous les monstres. Pour te féliciter voilà quelques points de vie supplémentaires. \n"
						+ " Voilà les 2 chemins qui s'offrent maintenant à toi :"
						+ "1. Utiliser une torche pour explorer les \"Grottes Luminescentes\" .\n"
						+ "2. Tenter de traverser le \"Pont Fragile\" en équilibre .\n",
				new ChoixSimple(10));

		ChanceNode node13 = new ChanceNode(
				"Jeune aventurier, c'est dommage, tu as échoué... Il te fallait surement plus d'entrainement! Tu perds un certain nombre de points de vie... \n"
						+ " Tu te retrouveras aléatoirement dans une de ces deux destinations :\n"
						+ "1. les \"Grottes Luminescentes\" .\n" + "2.  le \"Pont Fragile\" en équilibre .\n",
				-15);

		DecisionNode node14 = new DecisionNode(
				"Te voilà dans les grottes luminescentes, tu peux : \n\n \n"
						+ "1. Suivre la lueur des \"Cristaux Magiques\" pour trouver une sortie.\n"
						+ "2. Rencontrer des \"Chauves-Souris Géantes\" qui peuvent être amicales ou hostiles ",
				new ChoixSimple());

		DecisionNode node15 = new DecisionNode(
				"Quelle bon instinct! Stella est une amie solaire et de confiance. Fais bonne route avec elle",
				new ChoixSimple());

		ChanceNode node16 = new ChanceNode(
				"Ne jamais se fier aux apparances! Hanibal n'est pas un jeune homme de confiance, il est prêt à tout pour tuer son oncle \n"
						+ "Après une rude bataille, tu réussis à le semer et continue ton chemin mais tu perds des points de vie",
				-15);

		DecisionNode node17 = new DecisionNode(
				"Choisir de poursuivre son chemin avec Alma est une sage décision. Espérons qu'elle te protège par la suite",
				new ChoixSimple());

		ChanceNode node18 = new ChanceNode("Jeune Aventurier, tu te retrouves à l'entrée des Grottes Luminescentes. \n"
				+ "Malheureusement, tous les chemins ne mènent pas à Rome dans ces Grottes et le hasard te transportera dans une destination aléatoire, bonne chance!",
				-10);

		DecisionNode node19 = new DecisionNode("Vaillant ami, tu es face à un pont gardé par le fameux Lulu le Lutin"
				+ "Ce dernier s'apprête à te poser une redoutable énigme à laquelle tu dois répondre correctement pour continuer tranquillement ton aventure",
				banqueEnigme.getRandomEnigme());

		ChanceNode node20 = new ChanceNode(
				"\t Voyons voir si les chauves souris ont décidé d'être de gentilles créatures aujourd'hui", 0);

		DecisionNode node21 = new DecisionNode(
				"Vous vous retrouvez face à un volcan explosif d'où jaillissent des boules de feu. \n"
						+ "Tu as l'opportunité de ramasser une de ces boules, mais la question demeure : cela te sera-t-il bénéfique ?",
				new BouleMagique());

		DecisionNode node22 = new DecisionNode(
				"Tu te retrouves face à un volcan explosif d'où jaillissent des boules de feu. \n"
						+ "Tu as l'opportunité de ramasser une de ces boules, mais la question demeure : cela te sera-t-il bénéfique ?",
				new BouleMagique());

		DecisionNode node23 = new DecisionNode(
				"Vous vous retrouvez face à un volcan explosif d'où jaillissent des boules de feu. \n"
						+ "Tu as l'opportunité de ramasser une de ces boules, mais la question demeure : cela te sera-t-il bénéfique ?",
				new BouleMagique());

		DecisionNode node24 = new DecisionNode(
				"Tu tentes de suive la lueur des \"Cristaux Magiques\" pour trouver une sortie.\n", new ChoixSimple());

		DecisionNode node25 = new DecisionNode(
				"Tu te retrouves face à un volcan explosif d'où jaillissent des boules de feu. \n"
						+ "Tu as l'opportunité de ramasser une de ces boules, mais la question demeure : cela te sera-t-il bénéfique ?",
				new BouleMagique());

		DecisionNode node26 = new DecisionNode("\t Tu as su les dompter. Sylvanis est vraiment impressioné! \n"
				+ "Tu te diriges maintenant vers une dernière course contre la montre", new ChoixSimple());

		DecisionNode node27 = new DecisionNode(
				"\t Tu ne tires donc aucune leçon du Covid ? Les chauves-souris ne sont pas des animaux de confiance \n"
						+ "Tu te diriges maintenant vers une dernière course contre la montre",
				new ChoixSimple(-10));

		DecisionNode node28 = new DecisionNode("\t Faire confiance à Stella était vraiment le meilleur choix. \n"
				+ "Chacun de vous ayant déjà fait sa course contre la montre, vous n'avez pas besoin d'en effectuer une deuxième"
				+ " Tu es désormais prêt à quitter la jungle. Bravo à toi ! Si ce message s'affiche c'est que tu as trouvé le chemin idéal pour t'échapper",
				new ChoixSimple());

		DecisionNode node29 = new DecisionNode(
				"Ton amie, la louve Alma, t'a protégé du guépard Gabin qui était prêt à te poursuivre à nouveau pour une course"
						+ " Bravo pour tes bonnes décisions, tu t'échappes rapidement de la jungle!"
						+ " Si ce message s'affiche c'est que tu as réussi à t'en sortir rapidement",
				new ChoixSimple());

		
		DecisionNode node300 = new DecisionNode(
				"\n \t Gabin le guépard a fini par te retrouver et il te propose une dernière course au risque de te dévorer"
						+ "Tiens toi prêt !! \n\n",
				courseMontre2);
		
		SoundNode node30 = new SoundNode(node300,"./src/RUGISSEMENT du LION en COLERE.wav");

		TerminalNode node31 = new TerminalNode(
				"\n \t Il te reste quelques points de vie et tu as réussi à sortir vivant! Bravo! C'est la fin de cette aventure :)");

		nodes.add(node0);
		nodes.add(node1);
		nodes.add(node2);
		nodes.add(node3);
		nodes.add(node4);
		nodes.add(node5);
		nodes.add(node6);
		nodes.add(node7);
		nodes.add(node8);
		nodes.add(node9);
		nodes.add(node10);
		nodes.add(node11);
		nodes.add(node12);
		nodes.add(node13);
		nodes.add(node14);
		nodes.add(node15);
		nodes.add(node16);
		nodes.add(node17);
		nodes.add(node18);
		nodes.add(node19);
		nodes.add(node20);
		nodes.add(node21);
		nodes.add(node22);
		nodes.add(node23);
		nodes.add(node24);
		nodes.add(node25);
		nodes.add(node26);
		nodes.add(node27);
		nodes.add(node28);
		nodes.add(node29);
		nodes.add(node30);
		nodes.add(node31);

		int connexion[][] = new int[nodes.size()][nodes.size()];
		for (int i = 0; i < nodes.size(); i++)
			for (int j = 0; j < nodes.size(); j++)
				connexion[i][j] = 0;
		connexion[0][1] = 1;
		connexion[0][2] = 1;
		connexion[1][3] = 1;
		connexion[1][4] = 1;
		connexion[1][5] = 1;
		connexion[2][4] = 1;
		connexion[3][6] = 1;
		connexion[3][7] = 1;
		connexion[4][8] = 1;
		connexion[4][9] = 1;
		connexion[4][10] = 1;
		connexion[6][7] = 1;
		connexion[5][11] = 1;
		connexion[7][12] = 1;
		connexion[7][13] = 1;
		connexion[8][14] = 1;
		connexion[9][14] = 1;
		connexion[10][14] = 1;
		connexion[11][15] = 1;
		connexion[11][16] = 1;
		connexion[11][17] = 1;
		connexion[12][18] = 1;
		connexion[12][19] = 1;
		connexion[13][18] = 1;
		connexion[13][19] = 1;
		connexion[14][19] = 1;
		connexion[14][20] = 1;
		connexion[15][21] = 1;
		connexion[16][22] = 1;
		connexion[17][23] = 1;
		connexion[18][24] = 1;
		connexion[18][25] = 1;
		connexion[19][25] = 1;
		connexion[20][26] = 1;
		connexion[20][27] = 1;
		connexion[21][28] = 1;
		connexion[23][29] = 1;
		connexion[15][21] = 1;
		connexion[24][30] = 1;
		connexion[25][30] = 1;
		connexion[26][30] = 1;
		connexion[27][30] = 1;
		connexion[22][30] = 1;
		connexion[30][31] = 1;
		connexion[28][31] = 1;
		connexion[29][31] = 1;

		Graph graph = new Graph(nodes, connexion);

		return graph;
	}

}