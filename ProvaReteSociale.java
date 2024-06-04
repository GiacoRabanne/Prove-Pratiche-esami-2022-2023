import fond.io.*;
import java.util.LinkedList;
import java.util.Iterator;

public class ProvaReteSociale {
    public static void main(String[] args) {
        InputWindow in = new InputWindow();
        OutputWindow out = new OutputWindow();

        LinkedList<String> collezione = new LinkedList<>();

        boolean continua = true;
        while(continua) {
            collezione.add(in.readString("Inserisci un nome di persona:"));
            continua = !in.readBoolean("Desideri fermarti?");
        }

        // Ho la collezione pronta, ora la copio in un array di stringhe:

        // Avrei potuto usare un ciclo for per scandire le posizioni della linked list.
        String[] nomi = new String[collezione.size()];
        Iterator<String> it = collezione.iterator();
        int index = 0;
        while(it.hasNext()) {
            nomi[index] = it.next();
            index++;
        }

        ReteSociale rete = new ReteSociale(nomi);

        String menu = "";
        menu += "1) Aggiungi amicizia:\n";
        menu += "2) Cerca persona piu' popolare:\n";
        menu += "3) Mostra amici di:\n";
        menu += "4) Stampa rete:\n";
        menu += "5) Esci:\n";
        int scelta = in.readInt(menu + "Scelgli:");
        while(scelta < 1 && scelta > 5) {
            scelta = in.readInt("Valore non valido.\n" + menu + "Scegli:");
        }

        while(scelta != 5) {
            String output = "";
            if(scelta == 1) {
                String nome1 = in.readString("Inserisci il primo nome:");
                String nome2 = in.readString("Inserisci il secondo nome:");

                if(!rete.aggiungiAmicizia(nome1, nome2)) {
                    output = "Non tutti i nomi sono stati trovati.";
                } else {
                    output = "Amicizia aggiunta!";
                }

                output += "\n\n";
            } else if(scelta == 2) {
                output = "La persona piu' popolare e' " + rete.personaPiuPopolare() + "\n";
            } else if(scelta == 3) {
                String nome = in.readString("Inserisci il nome di chi vuoi ottenere gli amici:");
                String[] amici = rete.amiciDi(nome);

                if(amici.length == 0) {
                    output = nome + " non ha amici o non e' stato trovato.\n\n";
                } else {
                    if(amici.length == 1) {
                        output = "Amico"; 
                        System.out.println(output);
                    } else {
                        output = "Amici"; 
                    }
                    System.out.println("Entrato.\n");

                    output += " di " + nome + ":\n\t";
                    for(int i = 0; i < amici.length; i++) {
                        output += "- " + amici[i] + "\n\t";
                    }
                }
            } else if(scelta == 4) {
                output = rete.toString();
            }
            out.writeln(output);
            scelta = in.readInt(menu + "Scelgli:");
            while(scelta < 1 && scelta > 5) {
                scelta = in.readInt("Valore non valido.\n" + menu + "Scegli:");
            }
        }
    }

    
}
