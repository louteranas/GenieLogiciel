
public class strategie {
	private String nom;
	
	public strategie() {
		this.setNom("coucou");
	}
	
	public String getAction(String pastAction) {
		if(pastAction != "coucou") {
			return "coucou";
		}
		return pastAction;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
