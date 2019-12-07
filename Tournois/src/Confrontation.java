import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.text.html.HTMLDocument.Iterator;

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
		//if(verbose) System.out.println("########## Confrontation entre "+ strat1.getNom() +" et "+  strat2.getNom() +" :");
		for(int i = 0; i < this.nbTours; i++) {
			//if(verbose) System.out.println("==> Tours " +(i+1)+" :");
			Tours tours = new Tours();
			
			String lastStrat1 = this.strat1.play(historyStrat2, i);
			String lastStrat2 = this.strat2.play(historyStrat1, i);
			
			//if(verbose) System.out.println("Strat 1 plays : "+lastStrat1+".");
			//if(verbose) System.out.println("Strat 2 plays : "+lastStrat2+".");
			
			ArrayList<Integer> scores = tours.getResults(lastStrat1, lastStrat2);
			
			this.historyStrat1.add(lastStrat1);
			this.historyStrat2.add(lastStrat2);
			
			//if(verbose) System.out.println("Score 1 = "+scores.get(0)+".");
			//if(verbose) System.out.println("Score 2 = "+scores.get(1)+".");
			
			this.setScore1(this.getScore1() + scores.get(0));
			this.setScore2(this.getScore2() + scores.get(1));
			//if(verbose) System.out.println("--------------------------------------------------------------------------------------");
			
		}
		if(verbose) this.prettyPrintConfrontation();
		return this.score1;
		
	}
	
	public String printSpaces(int len) {
		String output = "";
		for(int i = 0; i<len; i++) {
			output += " ";
		}
		return output;
	}

	public void prettyPrintConfrontation() {
		System.out.println("############################## Confrontation : "+ strat1.getNom() +" Contre " + strat2.getNom() +" :");
		
		String start = "                          ";
		String space = "                        ";
		System.out.print(start);
		for(int i = 0; i<this.nbTours; i++) {
			String beforeSpace = this.printSpaces(Math.max(0,((space.length()-Integer.toString((i+1)).length())/2)));
			System.out.print("|"+beforeSpace+(i+1)+beforeSpace+this.printSpaces((space.length()-Integer.toString((i+1)).length())%2)+"|");
		}
		System.out.println("");
		String afterSpace1 = this.printSpaces(Math.max(0,((int)start.length()-strat1.getNom().length())));
		System.out.print(strat1.getNom()+afterSpace1);
		for(String tour : this.historyStrat1) {
			String margeSpace = this.printSpaces(Math.max(0,(space.length()-tour.length())/2));
			System.out.print("|"+margeSpace+tour+margeSpace+this.printSpaces((space.length()-tour.length())%2)+"|");
		}
		System.out.println("");
		String afterSpace = this.printSpaces(Math.max(0,((int)start.length()-strat2.getNom().length())));
		System.out.print(strat2.getNom()+afterSpace);
		for(String tour : this.historyStrat2) {
			String margeSpace = this.printSpaces(Math.max(0,(space.length()-tour.length())/2));
			System.out.print("|"+margeSpace+tour+margeSpace+this.printSpaces((space.length()-tour.length())%2)+"|");
		}
		System.out.println("");
		System.out.println("");
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
