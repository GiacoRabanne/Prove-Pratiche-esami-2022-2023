/* import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
 */
public class Posto {
	private char fila;
	private int numero;
	private int costo;
	private boolean libero;
	
	public Posto(char fila, int numero, int costo, boolean libero) {
		this.fila = fila;
		this.numero = numero;
		this.costo = costo;
		this.libero = libero;
	}

	public char getFila() {
		return fila;
	}

	public void setFila(char fila) {
		this.fila = fila;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public boolean isLibero() {
		return libero;
	}

	public void setLibero(boolean libero) {
		this.libero = libero;
	}

	public String toString() {
		return fila + "" + numero + " (" + costo + ", " + (libero?"L":"O")+")";
	}	
	
	/* public static void main(String[] args) {
		Map<Character,List<Posto>> platea=new HashMap<>();
		for(char c='A';c<='M';c++) {
			List<Posto> l=new ArrayList<>();
			for(int i=0;i<15;i++) {
				l.add(new Posto(c,i,200-(c-'A')*10,true));
			}
			platea.put(c,l);
		}
		
		for(char c='A';c<='M';c++) {
			List<Posto> l=platea.get(c);
			Iterator<Posto> it=l.iterator();
			
			while(it.hasNext()) {
				System.out.print(it.next()+" ");
			}
			System.out.println();
		}
			
	} */
}