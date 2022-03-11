package input;

import java.util.Vector;

/**
 * Classe pour une methode concrete.
 *
 */
public class Concrete extends Method {
	
	/**
	 * Le corps de la methode.
	 */
	protected String body;
	
	/**
	 * Constructeur de methode concrete.
	 * @param tp type de retour
	 * @param n name
	 * @param pars liste de parametres
	 * @param com commentaire
	 * @param b corps
	 */
	public Concrete(final String tp, final String n, 
			final Vector<Parameter> pars, final String com, final String b) {
		super(tp, n, pars, com);
		this.body = b;
		this.concrete = true;
	}

	/**
	 * Generation du code d'une methode concrete.
	 * @return une chaine
	 */
	public String generate() {
		// le commentaire
		String towrite = Keywords.TAB + Keywords.COMMENT 
				+ this.getComments() + Keywords.NEWLINE;
		// la declaration concrete
		towrite += Keywords.TAB + Keywords.PUBLIC;
		towrite += this.getType() + Keywords.BLANC + this.getName() + Keywords.PARIN;
		towrite +=	Keywords.PAROUT + Keywords.ACCIN + Keywords.NEWLINE;
		towrite += Keywords.TAB + Keywords.ACCOUT;
		return towrite;
		
	}

	/**
	 * 
	 * @return le corps de la methode.
	 */
	public String getBody() {
		return body;
	}

	/**
	 * Affecte le corps de la methode.
	 * @param body une chaine
	 */
	public void setBody(final String body) {
		this.body = body;
	}
}
