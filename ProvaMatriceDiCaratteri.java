import fond.io.*;

public class ProvaMatriceDiCaratteri {
    public static void main(String[] args) {
        InputWindow in = new InputWindow();
        OutputWindow out = new OutputWindow();

        int n = in.readInt("Inserisci la dimensione della matrice:");
        char[][] m = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                m[i][j] = in.readChar("Inserisci carattere in posizione (" + (i+1) + ", " + (j+1) + "):");
            }
        }

        MatriceDiCaratteri mat = new MatriceDiCaratteri(m);
        out.writeln(mat);
    }
}
