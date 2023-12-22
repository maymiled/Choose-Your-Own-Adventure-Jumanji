package univers;

import java.io.Serializable;

import vue.UI;

public abstract class Epreuve implements Serializable{
	
	
	public abstract void demarrer(UI ui);
	
	public abstract void jouer(UI ui);
	
	public abstract boolean aGagner(UI ui);
	
	public abstract int coutPointsVie();
	
	
}
