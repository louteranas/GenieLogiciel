import java.util.ArrayList;

public class StrategieMechante extends Strategie{
	public StrategieMechante () {
		super("Stratégie méchante", "Je trahis toujours");
	}
	public String play(ArrayList<String> History, int nTours) {
		return "T";
	}
}
