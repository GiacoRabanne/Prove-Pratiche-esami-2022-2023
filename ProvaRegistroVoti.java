import fond.io.*;

public class ProvaRegistroVoti {
    public static void main(String[] args) {
        InputWindow in = new InputWindow();
        OutputWindow out = new OutputWindow("Registro", 50, 50);

        int n = in.readInt("Inserisci il numero di studenti:");
        String[] nomi = new String[n];
        for(int i = 0; i < n; i++) {
            nomi[i] = in.readString("Inserisci il nome dello studente " + (i + 1) + ":");
        }

        int m = in.readInt("Inserisci il numero di materie:");
        String[] materie = new String[m];
        for(int i = 0; i < m; i++) {
            materie[i] = in.readString("Inserisci la materia " + (i+1) + ":");
        }

        RegistroVoti registro = new RegistroVoti(nomi, materie);
        out.writeln(registro.toString());

        boolean continua = true;
        while(continua) {
            String nome = in.readString("Inserisci il nome dello studente:");
            String materia = in.readString("Inserisci il nome della materia:");
            while(!registro.registraVoto(nome, materia, 0)) {
                nome = in.readString("Nome o Materia inserita non valida.\nInserisci il nome dello studente:");
                materia = in.readString("Inserisci il nome della materia:");
            }

            double voto = in.readDouble("Qual e' il voto di " + nome + " a " + materia + "?:");
            registro.registraVoto(nome, materia, voto);

            continua = in.readBoolean("Desideri continuare?:");
        }

        out.writeln(registro.toString());
        out.writeln("\nMedie degli Studenti:");
        double[] medie = registro.medieVoti();
        
        for(int i = 0; i < nomi.length; i++) {
            out.writeln("\t- " + nomi[i] + ": " + medie[i]);
        }
    }
}