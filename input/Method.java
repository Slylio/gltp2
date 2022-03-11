package input;

import java.util.Vector;

/**
 * Description simple d'une methode.
 * Elles sont publiques et abstraites par defaut
 *
 */
public class Method {
	/**
	 * Constante utile pour no parameter.
	 */
	public static final Vector<Parameter> NOPARAMETER = new Vector<Parameter>();
	
	/**
	 * Le type de retour.
	 */
	protected String type;
	
	/**
	 * Le nom de la methode.
	 */
	protected String name;
	
	/**
	 * Les parametres.
	 */
	protected Vector<Parameter> parameters;
	
	/**
	 * Abstraite ou pas.
	 */
	protected boolean concrete;
	
	/**
	 * Le commentaire. 
	 */
	protected String comments;
	
	/**
	 * Le constructeur de methode.
	 * @param tp type
	 * @param n nom
	 * @param pars parametre
	 * @param com abstraite ou non
	 */
	public Method(String tp, String n, Vector<Parameter> pars, String com) {
		this.type = tp;
		this.name = n;
		this.parameters = pars;
		this.concrete = false;
		this.comments = com;
	}

	/**
	 * 
	 * @return Nombre de parametres.
	 */
	public int arity() {
		return this.getParameters().size();
	}
	
	/**
	 * Generation du code d'une methode abstraite.
	 * @return une chaine
	 */
	public String generate() {
		// le commentaire
		String towrite = Keywords.TAB + Keywords.COMMENT 
				+ this.getComments() + Keywords.NEWLINE;
		// la declaration abstraite
		towrite += Keywords.TAB + Keywords.PUBLIC;
		towrite += Keywords.ABSTRACT;
		towrite += this.getType() + Keywords.BLANC + this.getName() + Keywords.PARIN;
		// les parametres
		towrite += this.generateParameters();
		towrite += Keywords.PAROUT + Keywords.SEMICOLON  + Keywords.NEWLINE;
		return towrite;
		
	}
	
	/**
	 * Generation des parametres.
	 * @return une liste de parametre
	 */
	public String generateParameters() {
		// TODO
		String towrite = "//TODO";
		return towrite;
	}
	
	/**
	 * 
	 * @return le type
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
	 * @return le nom
	 */
	public String getName() {
		return name;
	}

	/**
	 * Affecte le nom
	 * @param name une chaine
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return les parametres.
	 */
	public Vector<Parameter> getParameters() {
		return parameters;
	}

	/**
	 * Affecte les parametres.
	 * @param parameters un vecteur
	 */
	public void setParameters(Vector<Parameter> parameters) {
		this.parameters = parameters;
	}

	/**
	 * 
	 * @return si concrete ou non
	 */
	public boolean isConcrete() {
		return concrete;
	}

	/**
	 * @return le nom
	 */
	public String toString() {
		return this.getName();
	}

	/**
	 * 
	 * @return le commentaire.
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * Affecte le commentaire.
	 * @param comments le commentaire
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
}
