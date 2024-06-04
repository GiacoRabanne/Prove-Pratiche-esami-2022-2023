public class MatriceDiCaratteri {
    private char[][] mat;

    public MatriceDiCaratteri(char[][] m) {
        // Impongo che venga inizializzata una matrice quadrata a prescindere da ciò che l'utente fornisce.

        /* La dimensione della matrice quadrata è data dal minimo tra le righe e le colonne passate.*/ 
        int size = Math.min(m.length, m[0].length);

        this.mat = new char[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                this.mat[i][j] = m[i][j];
            }
        }
    }

    public boolean rigaUguale(int[] a) {
        boolean trovata = true;
        int size = this.mat.length;

        for(int i = 0; i < size; i++) {
            trovata = true;
            for(int j = 0; j < size && trovata; j++) {
                if(a[j] != this.mat[i][j]) {
                    trovata = false;
                }
            }
        }
        return trovata;
    }

    public MatriceDiCaratteri estraiSottomatrice(int i, int j) {
        MatriceDiCaratteri sub;
        if(i >= 0 && j < this.mat.length && i < j) {
            int size = j - i;
            char[][] m = new char[size][size];

            for(int k = 0; k < size; k++) {
                for(int h = 0; h < size; h++) {
                    m[k][h] = this.mat[i + k][i + h];
                }
            } 

            sub = new MatriceDiCaratteri(m);
        } else {
            sub = null;
        }

        return sub;
    }

    public String toString() {
        String s = "";
        int size = this.mat.length;

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                s += "| " + this.mat[i][j];
            }
            s += "|\n";
        }

        s += "\n";
        return s;
    }
}
