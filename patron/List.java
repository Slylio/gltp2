package patron;

/**
 * la classe racine du patron.
 * 
 * 
 */

public abstract class List extends Object {

	/**
	 * teste si la liste est vide ou pas.
	 * @return booleen
	 */
	public abstract boolean isEmpty();

	/**
	 * la longueur.
	 * @return entier
	 */
	public abstract int length();

	/**
	 * concatenation de deux  listes.
	 * @param l autre liste
	 * @return une liste
	 */
	public abstract List append(List l);

	/**
	 * Conversion.
	 * @return une chaine
	 */
	public abstract String toString();

	/**
	 * ajoute en tete d'une liste.
	 * @param e a ajouter
	 * @return une nouvelle liste
	 */
	public NotEmpty cons(int e) {
		return new NotEmpty(e, this);
	}

	/**
	 * ajout a la fin purement fonctionnelle.
	 * @param e a ajouter
	 * @return nouvelle liste
	 */ 
	public abstract NotEmpty putLast(int e);

	/**
	 * inversion purement fonctionnelle.
	 * @return une liste
	 */
	public abstract List reverse();

}
