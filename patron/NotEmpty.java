package patron;

/**
 * la classe des listes non vides.
 */
public class NotEmpty extends List {
	
	/**
	 * le champ tete.
	 */
	public int head;

	/**
	 * le champ reste.
	 */
	public List tail;

	/**
	 * le constructeur indispensable.
	 * @param e la tete de liste
	 * @param l le reste de la liste
	 */
	public NotEmpty(final int e, final List l) {
		head = e;
		tail = l;
	}

	/**
	 * teste la liste vide.
	 * @return un booleen
	 */
	public final boolean isEmpty() {
		return false;
	}

	/**
	 * la longueur.
	 * @return un entier
	 */
	public final int length() {
		return 1 + tail.length();
	}

	/**
	 * concatenation purement fonctionnelle.
	 * @param l
	 *            autre liste
	 * @return une liste
	 */
	public final List append(final List l) {
		return tail.append(l).cons(head);
	}

	/**
	 * ajout a la fin purement fonctionnelle.
	 * @param e a ajouter
	 * @return nouvelle liste
	 */ 
	public final NotEmpty putLast(final int e) {
		return tail.putLast(e).cons(head);
	}

	/**
	 * inversion purement fonctionnelle.
	 * @return une liste
	 */
	public final List reverse() {
		return tail.reverse().putLast(head);
	}

	/**
	 * redefinition.
	 * @return une chaine
	 */
	public final String toString() {
		return head + " " + tail.toString();
	}

}
