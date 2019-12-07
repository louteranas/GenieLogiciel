import java.util.ArrayList;

public class StrategieDonantDonant extends Strategie{

	public StrategieDonantDonant() {
		super("Stratégie Donant Donant", "Je trahis a la première partie, puis je joue ce qu'a joué l'autre la partie précédente");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String play(ArrayList<String> History, int nTours) {
		if(nTours == 0) {
			return "C";
		}
		else {
			return History.get(nTours-1);
		}
	}

}
