import fond.io.*;

public class ProvaMatrice {
    public static void main(String[] args) {
        InputWindow in = new InputWindow();
        OutputWindow out = new OutputWindow();
        out.setFont("SF Pro Display", 20);

        int n = in.readInt("Inserisci il numero di righe:");
        while(n <= 0) {
            n = in.readInt("Valore non valido.\nInserisci il numero di righe:");
        }
        int m = in.readInt("Inserisci il numero di colonne:");
        while(m <= 0) {
            m = in.readInt("Valore non valido.\nInserisci il numero di colonne:");
        }

        int[][] a = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = in.readInt("Inserisci l'elemento in posizione (" + (i+1) + ", " + (j+1) + "):");
            } 
        }

        Matrice mat = new Matrice(a);

        out.writeln(mat);
    }
}