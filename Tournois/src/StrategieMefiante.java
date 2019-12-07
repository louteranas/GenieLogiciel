import java.util.ArrayList;

public class StrategieMefiante extends Strategie{

	public StrategieMefiante() {
		super("Stratégie Méfiante", "Je trahis a la première partie, puis je joue ce qu'a joué l'autre la partie précédente");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String play(ArrayList<String> History, int nTours) {
		if(History.size() == 0) {
			return "T";
		}
		else {
			return History.get(nTours-1);
		}
	}

}
