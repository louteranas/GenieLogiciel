import java.util.ArrayList;

public class Tours {
	private ArrayList<Integer> scores;
	private int T = 5;
	private int D = 0;
	private int C = 3;
	private int P = 1;
	
	public Tours() {
		this.scores = new ArrayList<Integer>();
		this.scores.add(0);
		this.scores.add(0);
	}

	public ArrayList<Integer> getResults(String strat1, String strat2) {
		// TODO Auto-generated method stub
		if(strat1 == "T" && strat2 == "C") {
			this.scores.set(0, this.scores.get(0)+this.T);
			this.scores.set(1, this.scores.get(1)+this.D);
		}
		if(strat1 == "C" && strat2 == "T") {
			this.scores.set(0, this.scores.get(0)+this.D);
			this.scores.set(1, this.scores.get(1)+this.T);
		}

		if(strat1 == "T" && strat2 == "T") {
			this.scores.set(0, this.scores.get(0)+this.P);
			this.scores.set(1, this.scores.get(1)+this.P);
		}

		if(strat1 == "C" && strat2 == "C") {
			this.scores.set(0, this.scores.get(0)+this.C);
			this.scores.set(1, this.scores.get(1)+this.C);
		}
		return this.scores;
	}

}
