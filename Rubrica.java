import java.util.LinkedList;
import java.util.Iterator;

public class Rubrica {
    private LinkedList<Contatto> contatti;

    public Rubrica() {
        this.contatti = new LinkedList<>();
    }

    public void aggiungiContatto(String nome, String cognome, String numero) {
        this.contatti.add(new Contatto(nome, cognome, numero));
    }

    public void rimuoviContatto(String nome, String cognome) {
        Iterator<Contatto> it = this.contatti.iterator();

        boolean trovato = false;
        Contatto c = null;
        while(it.hasNext()) {
            c = it.next();
            if(c.getNome().equals(nome) && c.getCognome().equals(cognome)) {
                trovato = true;
                break;
            }
        }

        if(trovato) {
            this.contatti.remove(c);
        }
    }

    public String cerca(String nome, String cognome) {
        String s = null;
        Iterator<Contatto> it = this.contatti.iterator();
        while(it.hasNext()) {
            Contatto c = it.next();
            if(c.getNome().equals(nome) && c.getCognome().equals(cognome)) {
                s = c.getNumero();
            }
        }
        return s;
    }

    public String toString() {
        String s = "";
        Iterator<Contatto> it = this.contatti.iterator();
        while(it.hasNext()) {
            s += it.next().toString();
            s += "------------------\n";
        }
        return s;
    }
}
