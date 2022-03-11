package tests;

import patron.Empty;
import patron.List;
import patron.NotEmpty;

/**
 * patron liste classe de test.
  */
class TestPatron {
	/**
	 * methode principale.
	 * @param arg une chaine 
	 */
    public static void main(final String[] arg) {
	List l;
	Empty NULL = new Empty();
	System.out.println("nulle.isEmpty= " + NULL.isEmpty());
	System.out.println("nulle.length= " + NULL.length());
	l = new NotEmpty(3, new NotEmpty(2, new NotEmpty(1, NULL)));
	System.out.println("l.isEmpty= " + l.isEmpty());
	System.out.println("l.length= " + l.length());
	System.out.println("l= " + l);	
	System.out.println("l.reverse= " + l.reverse());
	System.out.println("l.append(l.reverse())= " + l.append(l.reverse()));	

    }
}

	
