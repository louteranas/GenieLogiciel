import java.util.ArrayList;

public class Confrontation {
	
	private Strategie strat1;
	private ArrayList<String> historyStrat1;
	private int score1;
	private Strategie strat2;
	private ArrayList<String> historyStrat2;
	private int score2;
	private int nbTours;
	
	public Confrontation(Strategie strat1, Strategie strat2, int nbTours) {
		this.strat1 = strat1;
		this.historyStrat1 = new ArrayList<String>();
		this.setScore1(0);
		this.strat2 = strat2;
		this.historyStrat2 = new ArrayList<String>();
		this.setScore2(0);
		this.nbTours = nbTours;
	}
	
	public int play(boolean verbose) {
		if(verbose) System.out.println("########## Confrontation entre "+ strat1.getNom() +" et "+  strat2.getNom() +" :");
		for(int i = 0; i < this.nbTours; i++) {
			if(verbose) System.out.println("==> Tours " +(i+1)+" :");
			Tours tours = new Tours();
			
			String lastStrat1 = this.strat1.play(historyStrat2);
			String lastStrat2 = this.strat2.play(historyStrat1);
			
			if(verbose) System.out.println("Strat 1 plays : "+lastStrat1+".");
			if(verbose) System.out.println("Strat 2 plays : "+lastStrat2+".");
			
			ArrayList<Integer> scores = tours.getResults(lastStrat1, lastStrat2);
			
			this.historyStrat1.add(lastStrat1);
			this.historyStrat2.add(lastStrat2);
			
			if(verbose) System.out.println("Score 1 = "+scores.get(0)+".");
			if(verbose) System.out.println("Score 2 = "+scores.get(1)+".");
			
			this.setScore1(this.getScore1() + scores.get(0));
			this.setScore2(this.getScore2() + scores.get(1));
			if(verbose) System.out.println("--------------------------------------------------------------------------------------");
			
		}
		return this.score1;
		
	}

	/**
	 * @return the score1
	 */
	public int getScore1() {
		return score1;
	}

	/**
	 * @param score1 the score1 to set
	 */
	public void setScore1(int score1) {
		this.score1 = score1;
	}

	/**
	 * @return the score2
	 */
	public int getScore2() {
		return score2;
	}

	/**
	 * @param score2 the score2 to set
	 */
	public void setScore2(int score2) {
		this.score2 = score2;
	}
	
}
