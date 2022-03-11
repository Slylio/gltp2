package input;

import java.util.Vector;

/**
 * Représentation simplifiee d'une classe.
 * Elles sont publiques
 *
 */
public class Class {
	
	/**
	 * Constante utile pour l'absence d'attribut.
	 */
	public static final Vector<Attribute> NOATTRIBUTE = new Vector<Attribute>();
	
	/**
	 * Le nom de la classe.
	 */
	protected String name;
	
	/**
	 * Ses attributs.
	 */
	protected Vector<Attribute> structure;
	
	/**
	 * Ses methodes.
	 */
	protected Vector<Method> behaviour;
	
	/**
	 * Abstraite ou non.
	 */
	protected boolean concrete;
	
	/**
	 * Super classe ou null sinon.
	 */
	protected String inherits;

	/**
	 * Constructeur d'une classe.
	 * @param n nom de la classe
	 * @param attr les attributs
	 * @param beh les methodes
	 * @param a concrete ou abstraite
	 * @param s nom super classe
	 */
	public Class(String n, Vector<Attribute> attr, Vector<Method> beh, boolean a, String s) {
		this.name = n;
		this.structure = attr;
		this.behaviour = beh;
		this.concrete = a;
		this.inherits = s;
	}
	
	/**
	 * Representation d'une classe.
	 * @return une chaine
	 */
	public String toString() {
		return "Classe : " + this.getName() + "\n"
		+ "Concrete : " + this.isConcrete() + "\n" 
		+ "Herite : " + this.getInherits() + "\n" 
		+ "Attributs : " + this.getStructure() + "\n" 
		+ "Comportements : " + this.getBehaviour() + "\n";
	}
	
	//------------- generation du code --------
	public String generate()  {
		String result = Keywords.PUBLIC;
		if (! this.isConcrete()) {
			result += Keywords.ABSTRACT;
		} 
		result += Keywords.CLASS + this.getName() + Keywords.BLANC;
		if (this.getInherits() != null) {
			result += Keywords.EXTENDS + this.getInherits();
		}
		result += Keywords.ACCIN + Keywords.NEWLINE + Keywords.NEWLINE;
		// les attributs
		for(Attribute at : this.getStructure()) {
			result += at.generate();
		}
		// les methodes
		for(Method met : this.getBehaviour()) {
			result += Keywords.NEWLINE + Keywords.NEWLINE;
			result += met.generate();
		}
		// } final
		result += Keywords.NEWLINE + Keywords.ACCOUT + Keywords.NEWLINE;
		return result;
	}
	
	/**
	 * @return Genere le code d'un constructeur complet.
	 */
	public String generateConstructor() {
		// TODO
		String towrite = Keywords.TAB + Keywords.COMMENT 
						+ "TODO Le constucteur complet." + Keywords.NEWLINE;
		return towrite + Keywords.TAB + Keywords.ACCOUT + Keywords.NEWLINE;
	}
	

	/**
	 * 
	 * @return le vecteur des attributs.
	 */
	public Vector<Attribute> getStructure() {
		return structure;
	}

	/**
	 * Affecte le vecteur des attributs.
	 * @param structure
	 */
	public void setStructure(final Vector<Attribute> structure) {
		this.structure = structure;
	}

	/**
	 * 
	 * @return le vecteur des methodes.
	 */
	public Vector<Method> getBehaviour() {
		return behaviour;
	}

	/**
	 * Affecte le vecteur des methodes.
	 * @param behaviour
	 */
	public void setBehaviour(Vector<Method> behaviour) {
		this.behaviour = behaviour;
	}

	/**
	 * 
	 * @return false si la classe est abstraite.
	 */
	public boolean isConcrete() {
		return concrete;
	}

	/**
	 * 
	 * @return le nom de la classe.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Affecte le nom de la classe.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return null ou la super classe.
	 */
	public String getInherits() {
		return inherits;
	}

	/**
	 * Affecte la super classe.
	 * @param inherits
	 */
	public void setInherits(String inherits) {
		this.inherits = inherits;
	}

	/**
	 * Affecte le statut concret.
	 * @param concrete
	 */
	public void setConcrete(boolean concrete) {
		this.concrete = concrete;
	}

}
