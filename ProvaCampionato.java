import fond.io.*;
import java.util.ArrayList;

public class ProvaCampionato {
    public static void main(String[] args) {
        InputWindow in = new InputWindow();
        OutputWindow out = new OutputWindow();
        ArrayList<String> collezione = new ArrayList<>();

        boolean continua = true;
        while(continua) {
            collezione.add(in.readString("Inserisci nome squadra:"));
            continua = !in.readBoolean("Desideri fermarti?");
        }

        String[] squadra = new String[collezione.size()];
        for(int i = 0; i < squadra.length; i++) {
            squadra[i] = collezione.get(i);
        }
        Campionato campionato = new Campionato(squadra);
        
        int scelta = in.readInt(ProvaCampionato.getMenu() + "Scegli:");
        while(scelta < 1 || scelta > 4) {
            scelta = in.readInt("Valore non valido\n" + ProvaCampionato.getMenu() + "Scegli:");
        }

        while(scelta != 4) {
            if(scelta == 1) {
                String sq1 = in.readString("Squadra in casa:");
                String sq2 = in.readString("Squadra fuori casa:");
                int r1 = in.readInt("Gol squadra in casa:");
                while(r1 < 0) {
                    r1 = in.readInt("Valore non valido.\nGol squadra in casa:");
                }
                int r2 = in.readInt("Gol squadra fuori casa:");
                while(r2 < 0) {
                    r2 = in.readInt("Valore non valido.\nGol squadra fuori casa:");
                }

                campionato.memorizzaRisultato(sq1, sq2, new Risultato(r1, r2));
            } else if(scelta == 2) {
                out.writeln(campionato.toString());
            } else if(scelta == 3) {
                out.writeln("Elenco Squadre con punti in classifica:");
                int[] punti = campionato.calcolaPunti();

                for(int i = 0; i < punti.length; i++) {
                    out.writeln("\t" + squadra[i] + ": " + punti[i] + " pt.");
                }
            }

            scelta = in.readInt(ProvaCampionato.getMenu() + "Scegli:");
            while(scelta < 1 || scelta > 4) {
                scelta = in.readInt("Valore non valido\n" + ProvaCampionato.getMenu() + "Scegli:");
            }
        }
    }

    public static String getMenu() {
        String menu = "";
        menu += "1) Inserisci risultato\n";
        menu += "2) Mostra tabella\n";
        menu += "3) Mostra punti in classifica\n";
        menu += "4) Esci\n";
        return menu;
    }
}
