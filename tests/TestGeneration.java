package tests;

import input.*;
import input.Class;

import java.security.Key;
import java.util.Vector;

/**
 * classe de test pour la representation d'une classe.
 * N'oubliez pas de faire un REFRESH !!!!!!!!!!!!
 * 
  */
class TestGeneration {
	/**
	 * main.
	 * @param args classique
	 */
    public static void main(final String[] args) {
    	
    	// repertoire de creation
    	String dir = "output";
    	// Noms des classes du patron
    	String root = "List", base = "Empty", composite = "NotEmpty";
    	
    	//-------------- auxillaires pour parametres
    	Vector<Parameter> pa = new Vector<Parameter>();
      	pa.add(new Parameter(root, "l"));
     	Vector<Parameter> ps = new Vector<Parameter>();
     	ps.add(new Parameter(Keywords.INT, "e"));
      	// ------------
        	
      	//============ root description (List)
    	// les methodes
       	Vector<Method> beh = new Vector<Method>();

       	// isEmpty 
       	beh.add(new Method(Keywords.BOOLEAN, "isEmpty", 
       			Method.NOPARAMETER, "teste si la liste est vide  ou pas."));

       	// length
       	beh.add(new Method(Keywords.INT, "length", 
       			Method.NOPARAMETER, "la longueur"));

      	// concatenation
      	beh.add(new Method(root, "append", pa, 
      		"concatenation de deux listes"));

     	// to string
      	beh.add(new Method(Keywords.STRING, "toString",
      			Method.NOPARAMETER, "Conversion."));

     	// cons 
      	beh.add(new Concrete(composite, "cons", ps, 
          		"Insertion en tete de liste", 
          		"return new NotEmpty(e, this);"));

    	// putlast
      	beh.add(new Method(composite, "putlast", ps, 
      		"Ajout en fin de liste"));

    	// reverse
      	beh.add(new Method(root, "reverse", Method.NOPARAMETER, 
      		"Inversion d'une liste"));
 
       	// la classe
     	Class list = new Class(root, Class.NOATTRIBUTE, beh, false, "Object");
      	
     	// ecriture du fichier
     	Write g = new Write(dir, list);
     	g.write();
     	g.close();
     	

		//-------------- auxillaires pour parametres
		Vector<Parameter> finalPa = new Vector<Parameter>();
      	pa.add(new Parameter(Keywords.FINAL+root, "l"));
     	Vector<Parameter> finalPs = new Vector<Parameter>();
     	ps.add(new Parameter(Keywords.FINAL+Keywords.INT, "e"));
		// ------------
     	//================ base description (Empty)
       	Vector<Method> beh1 = new Vector<Method>();

       	// isEmpty 
       	beh1.add(new Concrete(Keywords.FINAL+Keywords.BOOLEAN, "isEmpty", Method.NOPARAMETER, 
       			"teste si empty ou pas", "return true;"));
       	// length
      	beh1.add(new Concrete(Keywords.FINAL+Keywords.INT, "length", Method.NOPARAMETER, 
    			"Calcule la longueur de la liste", "return 0;"));
     	// to string
      	beh1.add(new Concrete(Keywords.FINAL+Keywords.STRING, "toString", Method.NOPARAMETER, 
          		"Conversion en chaine", "return \"\";"));
		
		// append
		beh1.add(new Concrete(Keywords.FINAL+list,"append",pa,
				"concatenation", "return l;"));
		
		//reverse 
		beh1.add(new Concrete(Keywords.FINAL+root, "reverse", Method.NOPARAMETER, 
				"inversion", "return this;"));
		
		//putLast
		beh1.add(new Concrete(Keywords.FINAL+composite, "putLast",finalPs,
				"ajout a la fin","return new NotEmpty(e,this);") );

       	// la classe
     	Class empty = new Class(base, Class.NOATTRIBUTE, beh1, true, root);
      	
     	// ecriture du fichier
     	Write g1 = new Write(dir, empty);
     	g1.write();
     	g1.close();
     	
     	//==================== composite description (NotEmpty)
       	// les attributs
       	Vector<Attribute> att = new Vector<Attribute>();
       	att.add(new Attribute(root, "tail"));
		att.add(new Attribute(root, "head"));

       	// les methodes
       	Vector<Method> beh2 = new Vector<Method>();
       	
		// isEmpty 
       	beh2.add(new Concrete(Keywords.FINAL+Keywords.BOOLEAN, "isEmpty", Method.NOPARAMETER, 
       			"teste si empty ou pas", "return false;"));

       	// length
       	beh2.add(new Concrete(Keywords.FINAL+Keywords.INT, "length", Method.NOPARAMETER, 
    			"Calcule la longueur de la liste", "return 1 + tail.length();"));
		
		//append
		beh2.add(new Concrete(Keywords.FINAL+root,"append",finalPa,
				"concatenation purement fonctionnelle.", "return tail.append(l).cons(head);"));
       	
		//putLast
		beh2.add(new Concrete(Keywords.FINAL+composite, "putLast", finalPs, 
				"ajout a la fin.","return tail.putlast(e).cons(head)"));
		
		beh2.add(new Concrete(Keywords.FINAL+root, "reverse", Method.NOPARAMETER, 
				"inversion purement fonctionenelle.","return tail.reverse().putLast(head)"));
		
		beh2.add(new Concrete(Keywords.FINAL+Keywords.STRING, "toString", Method.NOPARAMETER, 
				"redefinition.","return head+\" \"+ tail.toString()"));
		
		// la classe
     	Class notempty = new Class(composite, att, beh2, true, root);
      	
     	// ecriture du fichier
     	Write g2 = new Write(dir, notempty);
     	g2.write();
     	g2.close();
 
    }
}

	
