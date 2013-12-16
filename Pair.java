import java.util.Comparator;


public class Pair implements Comparable<Pair>{

	public String mot;
	public String resultatSplit[];
	public int nb;
	
	public int compareTo(Pair p) {
		if (this.nb > p.nb) 
			return -1;
		else 
			return 0;
		
	}
	
	public Pair(String mot, int nb){
		this.mot=mot;
		this.nb=nb;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public String[] getResultatSplit() {
		return resultatSplit;
	}

	public void setResultatSplit(String[] resultatSplit) {
		this.resultatSplit = resultatSplit;
	}

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}
	
}



	


