package input;

/**
 * Pr�sentation simplifiee d'un attribut.
 * Ils sont publiques, sans valeur initiales
 * 
 *
 */
public class Attribute {
	
	/**
	 * Le type.
	 */
	protected String type;
	
	/**
	 * Le nom de l'attribut.
	 */
	protected String name;
	
	/**
	 * Constructeur d'attribut.
	 * @param tp type
	 * @param n nom
	 */
	public Attribute(String tp, String n) {
		this.type = tp;
		this.name = n;
	}

	/**
	 * 
	 * @return genere le code.
	 */
	public String generate() {
		// TODO
		return "//TODO Attribute.generate";
	}
	
	/**
	 * 
	 * @return genere un parametre correspondant.
	 */
	public String generateParameter() {
		// TODO
		return "TODO";
	}
	
	/**
	 * 
	 * @return le type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Affecte le type.
	 * @param type une chaine
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return le nom.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Affecte le nom.
	 * @param n une chaine
	 */
	public void setName(String n) {
		this.name = n;
	}
	
	/**
	 * @return converion en chaine.
	 */
	public String toString() {
		return this.getName() + ":" + this.getType();
	}

}
