public class Campionato {
	private String[] squadre;
	private Risultato[][] risultati;

	public Campionato(String[] squadre) {
		int size = squadre.length;
		this.squadre = new String[size];
		for(int i = 0; i < size; i++) {
			this.squadre[i] = squadre[i];
		}
		this.risultati = new Risultato[size][size];
	}

	public String[] getSquadre() {
		int size = this.squadre.length;
		String[] squadre = new String[size];

		for(int i = 0; i < size; i++) {
			squadre[i] = this.squadre[i];
		}

		return squadre;
	}

	public void memorizzaRisultato(String sq1, String sq2, Risultato ris) {
		// Ricerca della squadra sq1 nelle righe:
		int i = -1;
		for(int k = 0; k < this.squadre.length; k++) {
			if(this.squadre[k].equals(sq1)) {
				i = k;
			}
		}

		if(i != -1) {
			int j = -1;

			for(int k = 0; k < this.squadre.length; k++) {
				if(this.squadre[k].equals(sq2)) {
					j = k;
				}
			}

			if(j != -1) {
				this.risultati[i][j] = ris;
			}
		}
	}

	public int[] calcolaPunti() {
		int size = this.squadre.length;
		int[] punti = new int[size];
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				// In casa (j per scandire le colonne):
				Risultato ris = risultati[i][j];
				if(ris != null) {
					if(ris.getGolCasa() > ris.getGolFuori()) {
						punti[i] += 3; // vittoria in casa
					} else if(ris.getGolCasa() == ris.getGolFuori()) {
						punti[i] += 1; // pareggio.
					}
				}

				// fuori casa (j per scandire le righe):
				ris = risultati[j][i];
				if(ris != null) {
					if(ris.getGolCasa() < ris.getGolFuori()) { 
						punti[i] += 3; // vittoria fuori casa
					} else if(ris.getGolCasa() == ris.getGolFuori()) {
						punti[i] += 1; // pareggio.
					}
				}
			}
		}
		
		return punti;
	}

	public String toString() {
		String s = "";
		// Ricavo la stringa con la lunghezza maggiore:
		int max = squadre[0].length();
		for(int i = 1; i < squadre.length; i++) {
			if(squadre[i].length() > max) {
				max = squadre[i].length();
			}
		}

		// ora che conosco la stringa con la lunghezza massima, faccio in modo tale che tutto sia ben ordinato:

		for(int i = 0; i < (max + 2)*(squadre.length+1); i++) {
			s += "=";
		}
		s += '\n'; 
		for(int i = 0; i < (max + 2); i++) {
			s += " ";
		}

		for(int i = 0; i < squadre.length; i++) {
			int diff = (max+2) - squadre[i].length();
			for(int j = 0; j < diff/2; j++) {
				s += " ";
			}
			s += squadre[i];
			for(int j = 0; j < diff/2 + diff%2; j++) {
				s += " ";
			}
		}

		s += '\n'; 

		for(int i = 0; i < squadre.length; i++) {
			s += squadre[i];
			for(int k = squadre[i].length(); k < max + 2; k++) {
				s += " ";
			}
			
			for(int j = 0; j < squadre.length; j++) {
				String ris;
				try {
					ris = risultati[i][j].toString();
				} catch(Exception e) {
					ris = "-";
				}
				int diff = (max+2) - ris.length();
				for(int k = 0; k < diff/2; k++) {
					s += " ";
				}
				s += ris;
				for(int k = 0; k < diff/2 + diff%2; k++) {
					s += " ";
				}
			}
			s += '\n';
		}

		for(int i = 0; i < (max+2)*(squadre.length + 1); i++) {
			s += "=";
		}
		s += '\n'; 

		return s;
	}
}