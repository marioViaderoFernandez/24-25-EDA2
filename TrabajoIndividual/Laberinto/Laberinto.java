public class Laberinto {

    private final char PARED = '#';
    private final char CAMINO = ' ';
    private final char VISITADO = '.';
    private final char PERSONAJE = 'P';
    private final char SALIDA = 'S';

    char[][] laberinto = {
            { '#', '#', '#', '#', '#', '#', '#' },
            { '#', 'P', '#', ' ', ' ', ' ', '#' },
            { '#', ' ', '#', ' ', '#', ' ', '#' },
            { '#', ' ', '#', ' ', '#', ' ', '#' },
            { '#', ' ', ' ', ' ', '#', ' ', '#' },
            { '#', ' ', '#', '#', '#', ' ', '#' },
            { '#', ' ', '#', '#', '#', ' ', '#' },
            { '#', '#', '#', '#', '#', 'S', '#' }
    };

    public boolean resolver() {
        int inicioFila = 1;
        int inicioColumna = 1;
        return resolver(inicioFila, inicioColumna);
    }

    public boolean resolver(int f, int c) {
        if (f < 0 || c < 0 || c > laberinto[0].length || f > laberinto.length || laberinto[f][c] == VISITADO
                || laberinto[f][c] == PARED) {
            return false;
        }

        if (laberinto[f][c] == SALIDA) {
            return true;
        }

       
        laberinto[f][c]= PERSONAJE;
        mostrarLaberinto();
        laberinto[f][c] = VISITADO;
        
        if (resolver(f + 1, c) || resolver(f - 1, c) || resolver(f, c + 1) || resolver(f, c - 1)) {
            
            return true;
        }
        laberinto[f][c] = CAMINO;
        mostrarLaberinto();
        return false;

    }

    public void mostrarLaberinto() {
        System.out.println();
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[0].length; j++) {
                System.out.print(laberinto[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}