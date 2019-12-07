import java.util.ArrayList;

public class StrategieRancuniere extends Strategie{

	public StrategieRancuniere() {
		super("Stratégie Méfiante", "Je coopère la première partie, mais dès que mon adversaire trahit, je trahis toujours");
		// TODO Auto-generated constructor stub
	}

	@Override
	public String play(ArrayList<String> History, int nTours) {
		if(nTours == 0 || !History.contains("T")) {
			return "C";
		}
		else {
			return "T";
		}
	}

}
