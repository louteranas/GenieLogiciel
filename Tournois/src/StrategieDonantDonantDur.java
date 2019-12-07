import java.util.ArrayList;

public class StrategieDonantDonantDur extends Strategie{

	public StrategieDonantDonantDur() {
		super("Stratégie Donant Donant Dur", "Je coopère la prememière partie, puis je coopère sauf si mon adversairea trahi lors l'une des deux parties précédentes");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String play(ArrayList<String> History, int nTours) {
		if(nTours == 0) {
			return "C";
		}
		if(nTours == 1 && History.get(nTours-1) != "T") {
			return "C";
		}
		if(nTours > 1 && History.get(nTours-1) != "T" && History.get(nTours-2) != "T") {
			return "C";
		}
		else {
			return "T";
		}
	}

}
