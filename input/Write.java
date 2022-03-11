package input;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Pour ouvrir le fichier en ecriture.
 *
 */
public class Write {
	/**
	 * le repertoire.
	 */
	protected String dir = "";

	/**
	 * suffixe.
	 */
	public static final String SUFFIX = ".java";

	/**
	 * Le fichier associe compte-tenu de l'OS.
	 */
	private File file;
	
	/**
	 * La classe a ecrire.
	 */
	protected Class towrite;
	
	/**
	 * le flot de sortie.
	 */
	private PrintWriter flot;

	/**
	 * accesseur en ecriture pour fullName.
	 * @param n le nom
	 */
	public final void setFullName(final String n) {
		this.setDir(n);
		// on suppose dir existe mais on peut le creer si on veut
		this.file = new File(this.getDir(), this.getTowrite().getName() + Write.SUFFIX);
		// possible de faire d'autres tests
		if (file.exists()) {
			System.out.println("Le fichier " + file + " existe, il sera ecrase");
		}
	}

	/**
	 *  Constructeur : ouvre le fichier en ecriture.
	 * @param n le nom
	 * @param cl la classe
	 */
	public Write(final String n, final Class cl) {
		this.towrite = cl;
		this.setFullName(n);
		try {
			this.flot = new PrintWriter(new FileWriter(this.getFile()));
		} catch (Exception e) {
			System.out.println("Write.Write : fichier alerte" + e);
		}
	}

	/**
	 * ecriture dans le fichier. 
	 */
	public void write() {
		try {
			// entete du fichier
			flot.println("// ---------------------------------");
			flot.println("// Ecriture dans un fichier de la classe ");
			flot.println("// nom dans le workspace courant ");
			flot.println("// " + this.getFile().getPath());
			flot.println("// ");
			flot.println("// ---------------------------------");
			flot.println();
			// ajout du package
			flot.println(Keywords.PACKAGE + this.getFile().getParent()
					.replace(File.separator, Keywords.DOT) 
					+ Keywords.SEMICOLON + Keywords.NEWLINE);
			flot.println(this.getTowrite().generate());
		} catch (Exception e) {
			System.out.println("Write.write : fichier alerte" + e);
		}
	}
	
	/**
	 * fermeture du fichier.
	 */
	public void close() {
		flot.close();
	}
	
	
	/**
	 * 
	 * @return le repertoire courant
	 */
	public String getDir() {
		return dir;
	}

	/**
	 * Affecte le repertoire.
	 * @param dir un chemin
	 */
	public void setDir(String dir) {
		this.dir = dir;
	}

	/**
	 * 
	 * @return la classe a generer.
	 */
	public Class getTowrite() {
		return towrite;
	}

	/**
	 * Affecte la classe
	 * @param towrite une classe
	 */
	public void setTowrite(Class towrite) {
		this.towrite = towrite;
	}

	public File getFile() {
		return file;
	}
}
