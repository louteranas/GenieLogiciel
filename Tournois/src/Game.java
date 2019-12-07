import java.util.ArrayList;
import java.util.Hashtable;

public class Game {
	public static void main(String[] args) {
		StrategieGentille strat1 = new StrategieGentille();
		StrategieMechante strat2 = new StrategieMechante();
		Tournois tournois = new Tournois(20);
		tournois.addStrategy(strat2);
		tournois.addStrategy(strat1);
		tournois.startTournois();
		tournois.prettyPrintScores();
		
		
    }
}
