public class RegistroVoti {
    private String[] nomi;
    private String[] materie;
    private double[][] voti;

    public RegistroVoti(String[] nomi, String[] materie) {
        this.nomi = new String[nomi.length];
        for(int i = 0; i < nomi.length; i++) {
            this.nomi[i] = nomi[i];
        }

        this.materie = new String[materie.length];
        for(int i = 0; i < materie.length; i++) {
            this.materie[i] = materie[i];
        }

        this.voti = new double[nomi.length][materie.length];
    }

    public String[] getNomi() {
        String[] nomi = new String[this.nomi.length];
        for(int i = 0; i < nomi.length; i++) {
            nomi[i] = this.nomi[i];
        }
        return nomi;
    }

    public boolean registraVoto(String nome, String materia, double voto) {
        // ricerca nome persona
        int i = -1, j = -1;
        for(int k = 0; k < this.nomi.length; k++) {
            if(this.nomi[k].toLowerCase().equals(nome.toLowerCase())) {
                i = k;
            }
        }

        if(i != -1) {
            for(int k = 0; k < this.materie.length; k++) {
                if(this.materie[k].toLowerCase().equals(materia.toLowerCase())) {
                    j = k;
                }
            }

            if(j != -1) {
                this.voti[i][j] = voto;
            }
        }

        return (i != -1 && j != -1);
    }

    public double[] medieVoti() {
        double[] medie = new double[this.nomi.length];

        for(int i = 0; i < medie.length; i++) {
            double media = 0;
            for(int j = 0; j < this.materie.length; j++) {
                media += this.voti[i][j];
            }
            media /= this.materie.length;
            medie[i] = media;
        }

        return medie;
    }

    public String toString() {
        String s = "Registro voti:\n|\t\t\t";

        for(int i = 0; i < this.materie.length; i++) {
            s += "|\t" + this.materie[i] + "\t";
        }
        s += "|\n";

        for(int i = 0; i < this.voti.length; i++) {
            s += "|\t" + this.nomi[i] + "\t";
            for(int j = 0; j < this.voti[0].length; j++) {
                s += "|\t" + this.voti[i][j] + "\t";
            }
            s += "|\n";
        }

        s += "\n";
        return s;
    }
}
