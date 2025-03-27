package TrabajoIndividual.BuscaminasRecursivo;

import java.util.Random;
import java.util.Scanner;

public class Buscaminas {
    private char[][] tablero;
    private boolean[][] liberada;
    private int nMinas;
    private boolean fin;

    public Buscaminas(int alto, int ancho, int nMinas) {
        this.tablero = new char[ancho][alto];
        this.liberada = new boolean[alto][ancho];
        this.nMinas = nMinas;
        this.fin = false;
        inicializarTablero();
        añadirMinas();
    }

    public void inicializarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '0';
                liberada[i][j] = false;
            }
        }

    }

    public void añadirMinas() {
        int contador = 0;

        while (contador < nMinas) {
            int randomFila = (int) ((Math.random() * 100) % tablero.length);
            int randomColumna = (int) ((Math.random() * 100) % tablero[0].length);

            if (!hayMina(randomFila, randomColumna)) {

                tablero[randomFila][randomColumna] = 'm';
                contador++;
                actualizarNumeros(randomFila, randomColumna);
            }
        }

    }

    public boolean hayMina(int c, int f) {

        if (tablero[c][f] == 'm') {
            return true;
        }

        return false;
    }

    public void mostrarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (liberada[i][j]) {
                    System.out.print(tablero[i][j] + " ");
                }else{
                    System.out.print("c ");
                }
            }
            System.out.println();
        }
    }

    public void actualizarNumeros(int x, int y) {
        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < tablero.length && ny >= 0 && ny < tablero[0].length && tablero[nx][ny] != 'm') {
                tablero[nx][ny]++;
            }
        }
    }

    public void jugar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Elija coordenadas: ");
        int c = sc.nextInt();
        int f = sc.nextInt();

        if (hayMina(c, f)) {
            System.out.println("Has perdido");
            fin = true;
        } else if (tablero[c][f] != '0') {
            liberada[c][f] = true;
        } else {
            descubrir(c,f);
        }
    }

    public void descubrir(int c, int f) {
        if (f < 0 || f >= tablero.length || c < 0 || c >= tablero[0].length || liberada[c][f]) {
            return;
        }
        liberada[c][f] = true;
        if (tablero[c][f] == '0') {
            int[] dc = { -1, -1, -1, 0, 0, 1, 1, 1 };
            int[] df = { -1, 0, 1, -1, 1, -1, 0, 1 };

            for (int i = 0; i < 8; i++) {
                descubrir(c + dc[i], f + df[i]);
            }
        }
    }

    public boolean esFin(){
        return fin;
    }

}
