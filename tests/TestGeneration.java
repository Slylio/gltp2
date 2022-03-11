package tests;

import input.Attribute;
import input.Class;
import input.Concrete;
import input.Keywords;
import input.Method;
import input.Parameter;
import input.Write;

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
     	
     	//================ base description (Empty)
       	Vector<Method> beh1 = new Vector<Method>();

       	// isEmpty 
       	beh1.add(new Concrete(Keywords.BOOLEAN, "isEmpty", Method.NOPARAMETER, 
       			"teste si empty ou pas", "return true;"));
       	// length
      	beh1.add(new Concrete(Keywords.INT, "length", Method.NOPARAMETER, 
    			"Calcule la longueur de la liste", "return 0;"));
     	// to string
      	beh1.add(new Concrete(Keywords.STRING, "toString", Method.NOPARAMETER, 
          		"Conversion en chaine", "return \"\";"));
		
		// append
		Vector<Parameter> parameters = new Vector<Parameter>();
		Parameter e=new Parameter(root, "l");
		parameters.add(e);
		beh1.add(new Concrete("final "+list,"append", parameters,
				"concatenation", "return l;"));
		
		//reverse 
		beh1.add(new Concrete("final "+root, "reverse", Method.NOPARAMETER, 
				"inversion", "return this;"));
		
		//putLast
		Vector<Parameter> parameters1 = new Vector<Parameter>();
		Parameter e1=new Parameter("final "+Keywords.INT, "e");
		parameters1.add(e1);
		beh1.add(new Concrete("final "+base, "putLast", parameters1, 
				"ajout a la fin.","return new NotEmpty(e, this"));

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

       	// les methodes
       	Vector<Method> beh2 = new Vector<Method>();

       	// isEmpty 
       	beh2.add(new Concrete(Keywords.BOOLEAN, "isEmpty", Method.NOPARAMETER, 
       			"teste si empty ou pas", "return false;"));

       	// length
       	beh2.add(new Concrete(Keywords.INT, "length", Method.NOPARAMETER, 
    			"Calcule la longueur de la liste", "return 1 + tail.length();"));
		
		//append
		Vector<Parameter> parameters2 = new Vector<Parameter>();
		Parameter e2=new Parameter("final "+root, "l");
		parameters2.add(e2);
		beh2.add(new Concrete(root,"append", parameters2,
				"concatenation purement fonctionnelle.", "return tail.append(l).cons(head);"));
       	
		//putLast
		Vector<Parameter> parameters3 = new Vector<Parameter>();
		Parameter e3=new Parameter("final "+Keywords.INT, "e");
		parameters3.add(e3);
		beh1.add(new Concrete("final "+composite, "putLast", parameters3, 
				"ajout a la fin.","return tail.putlast(e).cons(head)"));
		
		beh1.add(new Concrete("final "+root, "reverse", Method.NOPARAMETER, 
				"inversion purement fonctionenelle.","return tail.reverse().putLast(head)"));
		
		beh1.add(new Concrete("final "+Keywords.STRING, "toString", Method.NOPARAMETER, 
				"redefinition.","return head+\" \"+ tail.toString()"));
		
		// la classe
     	Class notempty = new Class(composite, att, beh2, true, root);
      	
     	// ecriture du fichier
     	Write g2 = new Write(dir, notempty);
     	g2.write();
     	g2.close();
 
    }
}

	
