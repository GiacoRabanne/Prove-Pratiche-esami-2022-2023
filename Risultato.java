public class Risultato {
	private int golCasa, golFuori;

	public Risultato(int golCasa, int golFuori) {
		this.golCasa = golCasa;
		this.golFuori = golFuori;	
	}

	public int getGolCasa() {
		return this.golCasa;	
	}

	public int getGolFuori() {
		return this.golFuori;	
	}

	public String toString() {
		return golCasa + "-" + golFuori;
	}
}