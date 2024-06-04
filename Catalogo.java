import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class Catalogo<E extends Articolo> {
    List<E> catalogo;

    public Catalogo() {
        this.catalogo = new LinkedList<>();
    }

    void aggiungiArticolo(E articolo) {
        this.catalogo.add(articolo);
    }

    List<E> getArticoliSottoPrezzo(double prezzo) {
        Iterator<E> it = this.catalogo.iterator();
        List<E> sottoList = new LinkedList<>();
        while(it.hasNext()) {
            if(it.next().getPrezzo() < prezzo) {
                sottoList.add(it.next());
            }
        }

        return sottoList;
    }
}