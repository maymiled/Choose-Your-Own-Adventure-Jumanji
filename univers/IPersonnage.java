package univers;

/**
 * Interface définissant un personnage
 *
 */
public interface IPersonnage {

	/**
	 * Action d'explorer un lieu ou un univer
	 * 
	 * @return nombre de points gagnés
	 */
	public int explorer();

	/**
	 * Action d'attaquer
	 * 
	 * @return nombre de points gagnés ou perdus si positif ou négatif
	 */
	public int attaquer();

	/**
	 * Action de négocier
	 * 
	 * @return nombre de points gagnés ou perdu si positif ou négatif
	 */
	public int negocier();

	/**
	 * Revenir en arrière
	 * 
	 * @returnnombre de points perdus
	 */
	public int reculer();
}
