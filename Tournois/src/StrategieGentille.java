import java.util.ArrayList;

public class StrategieGentille extends Strategie {
	public StrategieGentille () {
		super("Stratégie gentille", "Je coopère toujours");
	}
	public String play(ArrayList<String> History, int nTours) {
		return "C";
	}
}
