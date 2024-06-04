import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class PrenotazionePosti {
    private Map<Character, List<Posto>> platea;

    public PrenotazionePosti() { // Costruttore
        int costo = 200;
        // Creo l'oggetto Platea
        this.platea = new TreeMap<Character, List<Posto>>();
        // Scandisco le file che vanno da A alla M 
        for(char fila = 'A'; fila <= 'M'; fila++) {
            // Creo l'oggetto lista con una linked list e lo aggiungo alla fila della platea
            List<Posto> lista = new LinkedList<>();
            platea.put(fila, lista);

            for(int i = 0; i <= 20; i++) {
                Posto p = new Posto(fila, i, costo, true);
                // Aggiungo 21 posti alla lista di quella fila dopo averli creati.
                lista.add(p);
            }
            // Diminuisco il costo quando scendo di fila
            costo -= 10;
        }
    }

    public List<Posto> prenotaPostiInFila(char fila, int num) {
        List<Posto> lista = this.platea.get(fila);
        List<Posto> posti = null;
        boolean trovati = false;
        
        for(int i = 0; i < lista.size() && !trovati; i++) {
            Posto p = lista.get(i);
            if(p.isLibero()) {
                trovati = true;
                for(int j = 1; j < num && trovati; j++) {
                    if(!lista.get(i + j).isLibero()) {
                        trovati = false;
                    }
                }

                if(trovati) {
                    trovati = true;
                    posti = new LinkedList<>();
                    for(int j = i; j < i + num; j++) {
                        posti.add(lista.get(j));
                        lista.get(j).setLibero(false);
                    }   
                }
            }
        }

        return posti;
    }

    public List<Posto> prenotaPostiInFila(int num) {
        for(char fila = 'A'; fila <= 'M'; fila++) {
            List<Posto> posti = prenotaPostiInFila(fila, num);
            if(posti != null) {
                return posti;
            }
        }

        return null;
    }

    public String toString() {
        String s = "";

        for(char fila = 'A'; fila <= 'M'; fila++) {
            Iterator<Posto> it = this.platea.get(fila).iterator();
            while(it.hasNext()) {
                s += it.next(); 
            }
            s += '\n';
        }
        
        return s;
    }
}
