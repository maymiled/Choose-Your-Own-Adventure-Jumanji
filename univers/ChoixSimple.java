package univers;

import java.util.Random;

import vue.UI;

public class ChoixSimple extends Epreuve{
	
	private int coutPointVie;
	
	public ChoixSimple()
	{
		coutPointVie=0;
	}
	
	public ChoixSimple(int coutPointVie )
	{
		this.coutPointVie=coutPointVie;
	}

	@Override
	public void demarrer(UI ui) {		
	}

	@Override
	public void jouer(UI ui) {
		
	}

	@Override
	public boolean aGagner(UI ui) {
		
		return true;
	}

	@Override
	public int coutPointsVie() {
		return coutPointVie;
	}

}
;