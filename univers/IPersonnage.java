package univers;

/**
 * Interface d�finissant un personnage
 *
 */
public interface IPersonnage {

	/**
	 * Action d'explorer un lieu ou un univer
	 * 
	 * @return nombre de points gagn�s
	 */
	public int explorer();

	/**
	 * Action d'attaquer
	 * 
	 * @return nombre de points gagn�s ou perdus si positif ou n�gatif
	 */
	public int attaquer();

	/**
	 * Action de n�gocier
	 * 
	 * @return nombre de points gagn�s ou perdu si positif ou n�gatif
	 */
	public int negocier();

	/**
	 * Revenir en arri�re
	 * 
	 * @returnnombre de points perdus
	 */
	public int reculer();
}
