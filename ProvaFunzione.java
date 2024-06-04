import java.util.ArrayList;
import fond.io.*;

public class ProvaFunzione {
    public static void main(String[] args) {
        InputWindow in = new InputWindow();
        OutputWindow out = new OutputWindow("Funzioni");
        ArrayList<Funzione> funzioni = new ArrayList<>();

        boolean scelta = true;
        while(scelta) {
            int n = in.readInt("Inserisci il grado della funzione polinomiale:");
            double[] coeff = new double[n + 1]; // Se il grado è n, avro' bisogno di n+1 coefficienti.

            for(int i = n; i >= 1; i--) {
                coeff[i] = in.readDouble("Inserisci il coefficiente di x^" + i + ":");
            }
            coeff[0] = in.readDouble("Inserisci il termine noto:");

            funzioni.add(new FunzionePolinomiale(coeff));

            scelta = in.readBoolean("Desideri continuare?");
        }

        double x = in.readDouble("Inserisci un valore x:");

        for(int i = 0; i < funzioni.size(); i++) {
            Funzione derivata = funzioni.get(i).derivata();
            if(derivata.valore(x) > 0) {
                out.writeln(derivata);
                out.writeln("f'(" + x + ") = " + derivata.valore(x));
            }
        }
    }
}
