import fond.io.*;

public class ProvaRubrica {
    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica();
        InputWindow in = new InputWindow();
        OutputWindow out = new OutputWindow();
        out.setFont("SF Pro Display", 20);

        int opzione = in.readInt(opzioni() + "Scegli:");
        while(opzione < 1 || opzione > 5) {
            opzione = in.readInt("Valore non valido.\n" + opzioni() + "Scegli:");
        } 

        while(opzione != 5) {
            if(opzione == 1) {
                String nome = in.readString("Inserisci il nome:");
                String cognome = in.readString("Inserisci il cognome:");
                String numero = in.readString("Inserisci il numero di telefono:");
                rubrica.aggiungiContatto(nome, cognome, numero);
            } else if(opzione == 2) {
                String nome = in.readString("Inserisci il nome:");
                String cognome = in.readString("Inserisci il cognome:");
                rubrica.rimuoviContatto(nome, cognome);
            } else if(opzione == 3) {
                String nome = in.readString("Inserisci il nome:");
                String cognome = in.readString("Inserisci il cognome:");
                String numero = rubrica.cerca(nome, cognome);
                if(numero != null) {
                    out.writeln("Numero trovato: " + numero);
                } else {
                    out.writeln("Non e' stato trovato alcun numero.");
                }
            } else if(opzione == 4) {
                out.writeln(rubrica.toString());
            }

            opzione = in.readInt(opzioni() + "Scegli:");
            while(opzione < 1 || opzione > 5) {
                opzione = in.readInt("Valore non valido.\n" + opzioni() + "Scegli:");
            } 
        }
    }

    public static String opzioni() {
        String s = "";
        s += "1) Aggiungi contatto\n";
        s += "2) Rimuovi contatto\n";
        s += "3) Cerca\n";
        s += "4) toString\n";
        s += "5) Esci\n";
        return s;
    }
}
