import java.util.ArrayList;
import java.util.Hashtable;

public class Game {
	public static void main(String[] args) {
		StrategieGentille strat1 = new StrategieGentille();
		StrategieMechante strat2 = new StrategieMechante();
		StrategieMefiante strat3 = new StrategieMefiante();
		StrategieRancuniere strat4 = new StrategieRancuniere();
		StrategieDonantDonant strat5 = new StrategieDonantDonant();
		StrategieDonantDonantDur strat6 = new StrategieDonantDonantDur();
		boolean verbose = false;
		Tournois tournois = new Tournois(20);
		tournois.addStrategy(strat2);
		tournois.addStrategy(strat6);
		tournois.startTournois(verbose);
		tournois.prettyPrintScores();
		
		
    }
}
