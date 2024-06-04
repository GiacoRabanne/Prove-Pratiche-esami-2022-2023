public class Matrice {
    private int[][] mat;

    public Matrice(int[][] m) {
        int r = m.length;
        int c = m[0].length;
        this.mat = new int[r][c];

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                this.mat[i][j] = Math.abs(m[i][j]);
            }
        }
    }

    public void sommaIntorno(int i, int j, int[][] a) {
        for(int k = i - 1; k <= i + 1; k++) {
            for(int h = j - 1; h <= j + 1; h++) {
                if(k >= 0 && h >= 0 && k < this.mat.length && h < this.mat[0].length) {
                    this.mat[k][h] = a[k - i + 1][h - j + 1];
                }
            }
        }
    }

    public int[] intornoMinimo() {
        if(this.mat.length == 1 && this.mat[0].length == 1) {
            // se la matrice e' una cella unica ritorno la stessa cella
            return new int[] {0, 0};
        } else {
            // altrimenti determino l'intorno minore:
            int[] indici = new int[] {0, 0};

            // faccio la somma dei termini dell'intorno della cella 0,0
            int sommaMin = 0;
            int somma = 0;

            // ora verifico se ci sono altri posti in cui la somma e' inferiore.
            for(int i = 0; i < this.mat.length; i++) {
                for(int j = 0; j < this.mat[0].length; j++) {
                    for(int k = i - 1; k <= i + 1; k++) {
                        for(int h = j - 1; h <= j + 1; h++) {
                            if(k >= 0 && h >= 0 && k < this.mat.length && h < this.mat[0].length) {
                                somma += this.mat[h][k];
                            }
                        }
                    }

                    if(sommaMin > somma || (i == 0 && j == 0)) {
                        sommaMin = somma;
                        indici = new int[] {i, j};
                    }
                }
            }
            return indici;
        }
    }

    public String toString() {
        String s = "";
        int n = this.mat.length;
        int m = this.mat[0].length;

        for(int i = 0; i < n; i++) {
            s += "|";
            for(int j = 0; j < m; j++) {
                s += " " + this.mat[i][j] + " |";
            }
            s += '\n';
        }
        return s;
    }
}
