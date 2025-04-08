package TrabajoIndividual.BuscaminasRecursivo;

public class Main {
    public static void main(String[] args) {
        Buscaminas b = new Buscaminas(8, 8, 10);
        b.mostrarTablero();
        do{
            b.jugar();
            b.mostrarTablero();
        }while(!b.esFin());
    }
}
