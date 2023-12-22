package representation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import data.SaveData;
import univers.Epreuve;
import univers.Personnage;
import vue.FabriqueUI;
import vue.UI;

/**
 * Repr�sente une partie d'un jeu Un jeu est lanc� par une personne 'alias' en
 * choisissant un personnage donn�
 * 
 */
public class Game implements Serializable{

	private Personnage personne;
	private String alias;
	private Date dateDebut;
	private Node startNode;
	private Graph graph;

	public Game(String nomJoueur, String titrejeux, String mode) {
		graph = FabriqueVideotheque.creerInstance(titrejeux);
		this.startNode = graph.getStartNode();
		this.alias = nomJoueur;
		this.personne = new Personnage(nomJoueur, "", 100);
		FabriqueUI.creerUI(mode);
		System.out.println("Mode du jeu:" + mode);
	}

	public void start() {
		Node currNode = startNode;
		int pointsVie;
		UI ui = FabriqueUI.getUI();
		//Node sonNode = new SoundNode(node1, "chemin/vers/le/son.wav");
		while (currNode!=null) {
			ui.afficher(personne.toString());
			currNode.display();
			if (currNode instanceof TerminalNode)
				break;
			Epreuve epreuve = null;
			int coutPointsVie = 0;
			if (currNode instanceof ChanceNode) {
				ChanceNode chanceNode = ((ChanceNode) currNode);
				coutPointsVie = chanceNode.getCoutPointVie();
			}
			if (currNode instanceof DecisionNode) {
				epreuve = ((DecisionNode) currNode).getEpreuve();
				if (epreuve != null) {
					coutPointsVie = epreuve.coutPointsVie();
				}
			}

			if (coutPointsVie > 0) {
				pointsVie = Math.min(100, personne.getPointsDeVie() + coutPointsVie);
			} else {
				pointsVie = Math.max(0, personne.getPointsDeVie() + coutPointsVie);
			}
			personne.setPointsDeVie(pointsVie);
		
			
			currNode = currNode.chooseNext();
			
			if (personne.getPointsDeVie()<=0)
			{
				ui.afficher("Vous avez perdu le jeu.\n FIN");
				break;
			}
			
			ui.afficher("(Q:Quitter --- S:Sauvegarder --- Enter:Continuer)");
			char choix = readOption();
			if (choix=='Q')
					break;
			if (choix=='S')
			{
				SaveData.saveGame(this);
			}
		}	
		
		ui.afficher("FIN DU JEU");

	}
	
	private char readOption()
	{
		try {
			int charCode = System.in.read();
			return (char) charCode;
		}
		catch (Exception e) {;}
		return ' ';
	}

	public Personnage getPersonne() {
		return personne;
	}

	public void setPersonne(Personnage personne) {
		this.personne = personne;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

};;