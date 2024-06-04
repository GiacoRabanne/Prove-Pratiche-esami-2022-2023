import java.util.Iterator;
import java.util.List;

import fond.io.*;

public class ProvaPrenotazionePosti {
    public static String opzioni() {
        String s = "";
        s += "1. Stampa Posti\n";
        s += "2. Prenota Posti per Fila\n";
        s += "3. Prenota Posti\n";
        s += "4. Esci\n";

        return s;
    }
    public static void main(String[] args) {
        InputWindow in = new InputWindow();
        OutputWindow out = new OutputWindow();
        out.setFont("SF Pro Display", 15);

        PrenotazionePosti posti = new PrenotazionePosti();
        int scelta = in.readInt(opzioni() + "Scegli Posto:");
        while(scelta < 1 || scelta > 4) {
            scelta = in.readInt("Valore errato\n" + opzioni() + "Scegli Posto:");
        }

        while(scelta != 4) {
            if(scelta == 1) {
                out.writeln(posti);
            } else if(scelta == 2) {
                char fila = in.readChar("Inserisci la fila desiderata (dalla A alla M): ");
                //
                fila = Character.toUpperCase(fila);
                System.out.println(fila);

                while(fila < 'A' || fila > 'M') {
                    fila = in.readChar("Valore Errato.\nInserisci la fila desiderata (dalla A alla M): ");
                }
                int num = in.readInt("Inserisci il numero di posti da cercare: ");
                //
                
                List<Posto> l = posti.prenotaPostiInFila(fila, num);
                if(l == null) {
                    out.writeln("Non sono disponibili i posti nella fila " + fila);
                } else {
                    Iterator<Posto> it = l.iterator();
                    out.writeln("Posti prenotati:");
                    while(it.hasNext()) {
                        out.writeln(it.next().toString());
                    }
                }
            } else if(scelta == 3) {
                int num = in.readInt("Inserisci il numero di posti da cercare: ");

                List<Posto> l = posti.prenotaPostiInFila(num);
                if(l == null) {
                    out.writeln("Non sono disponibili i posti in nessuna fila ");
                } else {
                    Iterator<Posto> it = l.iterator();
                    out.writeln("Posti prenotati:");
                    while(it.hasNext()) {
                        out.writeln(it.next().toString());
                    }
                }
            }

            scelta = in.readInt(opzioni() + "Scegli Posto:");
            while(scelta < 1 || scelta > 4) {
                scelta = in.readInt("Valore errato\n" + opzioni() + "Scegli Posto:");
            }   
        }
    }
}
