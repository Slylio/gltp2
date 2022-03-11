package input;

/**
 * Classe simple pour les parametres.
 *
 */
public class Parameter {
	
	/**
	 * Le type du parametre.
	 */
	protected String type;
	
	/**
	 * La variable.
	 */
	protected String variable;
	
	/**
	 * Le constructeur de parametre.
	 * @param t
	 * @param n
	 */
	public Parameter(String t, String n) {
		this.type = t;
		this.variable = n;
	}

	/**
	 * @return le code genere.
	 */
	public String generate() {
		// TODO
		return "//TODO\n";
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
	 * @param type
	 */
	public void setType(final String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return nom de la variable.
	 */
	public String getVariable() {
		return variable;
	}

	/**
	 * Affecte le nom.
	 * @param variable
	 */
	public void setVariable(String variable) {
		this.variable = variable;
	}

}
