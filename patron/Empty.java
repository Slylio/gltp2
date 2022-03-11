package patron;

/**
 * liste vide.
 * 
 */
public class Empty extends List {

	/**
	 * constructeur des listes vides.
	 */
	public Empty() { };

	/**
	 * teste de la liste vide.
	 * @return booleen
	 */
	public final boolean isEmpty() {
		return true;
	}

	/**
	 * longueur.
	 * @return entier
	 */
	public final int length() {
		return 0;
	}

	/**
	 * ajout a la fin.
	 * @param e l'entier a ajouter
	 * @return une liste non vide
	 */
	public final NotEmpty putLast(final int e) {
		return new NotEmpty(e, this);
	}

	/**
	 * inversion.
	 * @return une liste
	 */
	public final List reverse() {
		return this;
	}

	/**
	 * concatenation.
	 * @param l liste a concatener
	 * @return une vouvelle liste
	 */
	public final List append(final List l) {
		return l;
	}

	/**
	 * redefinition de toString.
	 * @return une chaine
	 */
	public final String toString() {
		return "";
	}
}
