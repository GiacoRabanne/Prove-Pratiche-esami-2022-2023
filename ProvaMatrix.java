import fond.io.*;

public class ProvaMatrix {
    public static void main(String[] args) {
        InputWindow in = new InputWindow();
        OutputWindow out = new OutputWindow();

        int n = in.readInt("Qual e' la dimensione delle due matrici?");
        int[][] aInt = new int[n][n];
        int[][] bInt = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                aInt[i][j] = in.readInt("Matrice A:\nInserisci l'elemento in posizione (" + i + ", " + j + "):");
                bInt[i][j] = in.readInt("Matrice B:\nInserisci l'elemento in posizione (" + i + ", " + j + "):");
            }
        }

        
        int[][] prod = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                prod[i][j] = aInt[i][j] * bInt[j][i];
            }
        }

        Matrix matrice = new Matrix(prod);

        out.writeln(matrice);

        for(int i = 0; i < n; i++) {
            out.writeln("Cella in diagonale principale di indice i = " + i);
            out.writeln("Valore intorno superiore: " + matrice.sommaQuadranteSuperiore(i, i));
            out.writeln("Valore intorno inferiore: " + matrice.sommaQuadranteInferiore(i, i));
        }
    }
}