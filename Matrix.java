public class Matrix {
    private int[][] mat;
    
    public Matrix(int[][] m) {
        /* Anche se l'utente dovesse passare un array di dimensione nxm con m != n,
        verrebbe creato un array quadrato  */
        int n = Math.min(m.length, m[0].length);
        
        this.mat = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                this.mat[i][j] = m[i][j];
            }
        }
    }

    public int sommaQuadranteInferiore(int i, int j) {
        // Assumendo che 0 <= i <= n-1 e 0 <= j <= n-1 
        int somma = 0;
        int size = this.mat.length;

        for(int h = i+1; h < size; h++) {
            for(int k = j+1; k < size; k++) {
                somma += this.mat[h][k];
            }
        }
        return somma;
    }

    public int sommaQuadranteSuperiore(int i, int j) {
        // Assumendo che 0 <= i <= n-1 e 0 <= j <= n-1 
        int somma = 0;

        for(int h = 0; h < i; h++) {
            for(int k = 0; k < j; k++) {
                somma += this.mat[h][k];
            }
        }
        return somma;
    }

    public int[][] sommaQuadrantiSuperiori() {
        int n = this.mat.length;
        int[][] a = new int[n][2];

        for(int i = 0; i < n; i++) {
            a[i][0] = this.sommaQuadranteSuperiore(i, i);
            a[i][1] = this.sommaQuadranteInferiore(i, i);
        }

        return a;
    }

    public String toString() {
        String s = "";
        int n = this.mat.length;

        for(int i = 0; i < n; i++) {
            s += "| ";
            for(int j = 0; j < n; j++) {
                s += "[ " + this.mat[i][j] + " ] ";
            }
            s += "|\n";
        }
        return s;
    }
}
