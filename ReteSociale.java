public class ReteSociale {
	private String[] nomi;
	private int[][] amicizie;
	
	public ReteSociale(String[] nomi) {
		int size = nomi.length;
		this.nomi = new String[size];
		
		for(int i = 0; i < size; i++) {
			this.nomi[i] = nomi[i];
		} 

		this.amicizie = new int[size][size];
	}

	public boolean aggiungiAmicizia(String nome1, String nome2) {
		boolean trovati = false;
        int i = -1, j = -1;
		for(int k = 0; k < this.nomi.length && !trovati; k++) {
            String nome = this.nomi[k];
			if(nome.equals(nome1)){
                i = k;
                if(j != -1) {
                    trovati = true;
                }
			} else if(nome.equals(nome2)) {
                j = k;
                if(i != -1) {
                    trovati = true;
                }
            }
		}

        if(i != -1 && j != -1) {
            amicizie[i][j] = 1;
            amicizie[j][i] = 1;
        }

        return trovati;
	}

    public String personaPiuPopolare() {
        String popolare = this.nomi[0];
        int piuPop = 0;

        for(int i = 0; i < this.amicizie.length; i++) {
            int popolarita = 0;
            for(int j = 0; j < this.amicizie[0].length; j++) {
                popolarita += amicizie[i][j];
            }

            if(popolarita > piuPop) {
                piuPop = popolarita;
                popolare = this.nomi[i];
            }
        }
        return popolare;
    }

    public String[] amiciDi(String nome) {
        // Ricerca nome:
        int i = -1;
        for(int j = 0; j < this.nomi.length; j++) {
            if(this.nomi[j].equals(nome)) {
                i = j;
            }
        }

        String[] amici;
        if(i == -1) { // Caso in cui non trovo il nome:
            amici = new String[0];
        } else {
            // Conto il numero di amici:
            int size = 0;
            for(int j = 0; j < this.amicizie.length; j++) {
                size += this.amicizie[i][j];
            }

            amici = new String[size];

            // Inserisco le stringhe degli amici
            int index = 0;

            for(int j = 0; j < this.amicizie.length && index < size; j++) {
                if(this.amicizie[i][j] == 1) {
                    amici[index] = this.nomi[j];
                    index++;
                }
            }
        }

        return amici;
    }

    public String toString() {
        String s = "";
        int max = 0;

        for(int i = 0; i < this.nomi.length; i++) {
            int length = nomi[i].length();
            if(length > max) {
                max = length;
            }
        }

        for(int i = 0; i < (max + 2)*(nomi.length + 1); i++) {
            s += "=";
        }
        s += '\n';
        for(int i = 0; i < (max + 2); i++) {
            s += " ";
        }

        int diff;
        for(int i = 0; i < nomi.length; i++) {
            diff = (max + 2) - nomi[i].length();

            for(int j = 0; j < diff/2; j++) {
                s += " ";
            }
            s += nomi[i];
            for(int j = 0; j < diff/2 + diff%2; j++) {
                s += " ";
            }
        }
        s += '\n';

        for(int i = 0; i < amicizie.length; i++) {
            s += nomi[i];
            diff = max + 2 - nomi[i].length();
            for(int j = 0; j < diff; j++) {
                s += " ";
            }
            for(int j = 0; j < amicizie[0].length; j++) {
                diff = (max + 2) - 1;
                for(int k = 0; k < diff/2; k++) {
                    s += " ";
                }
                s += amicizie[i][j];
                for(int k = 0; k < diff/2 + diff%2; k++) {
                    s += " ";
                }
            }
            s += '\n';
        }
        for(int i = 0; i < (max + 2)*(nomi.length + 1); i++) {
            s += "=";
        }

        return s;
    }

}