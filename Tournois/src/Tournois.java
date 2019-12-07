import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Tournois {
	
	private int nbTours;
	private Hashtable<String, Hashtable<String, Integer>> scores;
	private ArrayList<String> strategiesNames;
	private ArrayList<Strategie> strategies;
	
	public Tournois(int nbTours) {
		this.nbTours = nbTours;
		this.scores = new Hashtable<String, Hashtable<String, Integer>> ();
		this.strategiesNames = new ArrayList<String>();
		this.strategies = new ArrayList<Strategie>();
	}
	
	public int getNbTours() {
		return nbTours;
	}
	
	public Hashtable<String, Hashtable<String, Integer>> getScores() {
		return scores;
	}

	public ArrayList<String> getStrategies() {
		return strategiesNames;
	}

	public void addStrategy(Strategie strategy) {
		this.strategies.add(strategy);
		this.strategiesNames.add(strategy.getNom());
	}
	
	public void startTournois(boolean verbose){
		for(int i = 0; i<this.strategies.size(); i++) {
			Hashtable<String, Integer> confsScores = new Hashtable<String, Integer>();
			for(int j = 0; j<this.strategies.size();j++) {
				Confrontation conf = new Confrontation(this.strategies.get(i), this.strategies.get(j), this.nbTours);
				int score = conf.play(verbose);
				confsScores.put(this.strategies.get(j).getNom(), score);
			}
			this.scores.put(this.strategies.get(i).getNom(), confsScores);
		}
	}
	
	public void printScores() {
		System.out.println("######################## Scores ######################");
		Enumeration<String> keys = this.scores.keys();
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			System.out.println("===========> Score pour " + key + ".");
			Hashtable<String, Integer> score = this.scores.get(key);
			Enumeration<String> subKeys = score.keys();
			int scoreTotal = 0;
			while(subKeys.hasMoreElements()) {
				String subKey = subKeys.nextElement();
				scoreTotal += score.get(subKey);
				System.out.println("Score contre "+subKey +" : " + score.get(subKey));
			}
			System.out.println("- Le score total de "+ key +" est donc de : " + scoreTotal +".");
			System.out.println("");
		}
	}
	public String printSpaces(int len) {
		String output = "";
		for(int i = 0; i<len; i++) {
			output += " ";
		}
		return output;
	}
	
	public void prettyPrintScores() {
		System.out.println("############################################################ Scores ############################################################");
		
		String start = "                              ";
		String space = "                            ";
		System.out.print(start);
		Enumeration<String> keys = this.scores.keys();
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			String beforeSpace = this.printSpaces(Math.max(0,((int)space.length()-key.length())/2));
			System.out.print("|"+beforeSpace+key+beforeSpace+"|");
		}
		String beforeSpace = this.printSpaces(Math.max(0,((int)space.length()-"Total".length())/2));
		System.out.print("|"+beforeSpace+"Total"+beforeSpace+" |");
		System.out.println("");

		keys = this.scores.keys();
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			String afterSpace = this.printSpaces(Math.max(0,((int)start.length()-key.length())));
			System.out.print(key+afterSpace);

			Hashtable<String, Integer> score = this.scores.get(key);
			Enumeration<String> subKeys = score.keys();
			int scoreTotal = 0;
			while(subKeys.hasMoreElements()) {
				String subKey = subKeys.nextElement();
				scoreTotal += score.get(subKey);
				String margeSpace = this.printSpaces(Math.max(0,(space.length()-Integer.toString(score.get(subKey)).length())/2));
				System.out.print("|"+margeSpace+score.get(subKey)+margeSpace+ this.printSpaces((space.length()-Integer.toString(score.get(subKey)).length())%2)+"|");
			}
			String marge = this.printSpaces(Math.max(0,((int)space.length()-Integer.toString(scoreTotal).length())/2));
			System.out.print("|"+marge+scoreTotal+marge+this.printSpaces((space.length()-Integer.toString(scoreTotal).length())%2)+"|");
			System.out.println("");
//			System.out.println("");
		}
	}
	
	
}
