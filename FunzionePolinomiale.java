public class FunzionePolinomiale implements Funzione {
    private double[] a;

    public FunzionePolinomiale(double[] coefficienti) {
        int size = coefficienti.length;
        this.a = new double[size];

        for(int i = 0; i < size; i++) {
            this.a[i] = coefficienti[i];
        }
    }

    public double valore(double x) {
        double valore = 0;

        for(int i = 0; i < this.a.length; i++) {
            valore += this.a[i] * Math.pow(x, i);
        }

        return valore;
    }

    public Funzione derivata() {
        Funzione derivata;
        if(this.a.length == 1) {
            derivata = new FunzionePolinomiale(new double[] {0});
        } else {
            double[] b = new double[this.a.length - 1];

            for(int i = 0; i < b.length; i++) { 
                b[i] = this.a[i+1] * (i+1);
            }

            derivata = new FunzionePolinomiale(b);
        }
        return derivata;
    }

    public String toString() {
        String s = "f(x) = ";

        for(int i = this.a.length - 1; i >= 1; i--) {
            double a = Math.abs(this.a[i] * 100)/100.0; // viene approssimato il valore a due cifre dopo la virgola

            if(a < 0) {
                s += "- " + (- a) + "x^" + i + " ";
            } else if(a > 0) {
                s += "+ " + (a) + "x^" + i + " ";
            }
        }

        double a = Math.abs(this.a[0] * 100)/100.0;

        if(a < 0) {
            s += "- " + (- a);
        } else {
            s += "+ " + (a);
        }

        return s;
    }
}
