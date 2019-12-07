import java.util.ArrayList;

public abstract class Strategie {
	// name of start
	private String nom;
	// Documentation of strat to know how it plays
	private String doc;
	
	public Strategie(String nom, String doc) {
		this.nom = nom;
		this.doc = doc;
	}
	
	abstract public String play(ArrayList<String> History, int nTours);

	public String getNom() {
		return nom;
	}
	
	public String getDoc() {
		return doc;
	}
}
